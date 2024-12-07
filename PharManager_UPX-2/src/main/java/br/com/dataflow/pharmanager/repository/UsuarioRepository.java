package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;
import br.com.dataflow.pharmanager.model.Usuario;

public class UsuarioRepository {
    private final EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    private boolean usuarioJaExiste(String usuario) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.usuario = :usuario", Long.class);
        query.setParameter("usuario", usuario);
        return query.getSingleResult() > 0;
    }

    private void validarUsuario(Usuario usuario, boolean isAtualizacao) {
        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
        }
        if (usuario.getUsuario() == null || usuario.getUsuario().isBlank()) {
            throw new IllegalArgumentException("O nome de usuário é obrigatório.");
        }

        // Verificar se o nome de usuário já existe (para operações de criação)
        if (!isAtualizacao && usuarioJaExiste(usuario.getUsuario())) {
            throw new IllegalArgumentException("O nome de usuário já está em uso.");
        }

        // Verificar se o nome de usuário já existe em atualizações (caso esteja alterando o usuário)
        if (isAtualizacao) {
            TypedQuery<Long> query = entityManager.createQuery(
                    "SELECT COUNT(u) FROM Usuario u WHERE u.usuario = :usuario AND u.id <> :id", Long.class);
            query.setParameter("usuario", usuario.getUsuario());
            query.setParameter("id", usuario.getId());
            if (query.getSingleResult() > 0) {
                throw new IllegalArgumentException("O nome de usuário já está em uso por outro registro.");
            }
        }
    }

    public void salvar(Usuario usuario) {
        validarUsuario(usuario, false); // Validação para novo cadastro
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar o usuário: " + e.getMessage(), e);
        }
    }

    public void atualizar(Usuario usuario) {
        validarUsuario(usuario, true); // Validação para atualização
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar o usuário: " + e.getMessage(), e);
        }
    }

    public List<Usuario> listarTodos() {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }

    public Usuario buscarPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    public Usuario buscarPorUsuario(String usuario) {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.usuario = :usuario", Usuario.class);
        query.setParameter("usuario", usuario);
        List<Usuario> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public void excluir(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(usuario);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw new RuntimeException("Erro ao excluir o usuário: " + e.getMessage(), e);
            }
        }
    }

    public List<Usuario> buscarUsuariosAtivos() {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.estado = true", Usuario.class);
        return query.getResultList();
    }

    public List<Usuario> buscarUsuariosInativos() {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.estado = false", Usuario.class);
        return query.getResultList();
    }

    public List<Usuario> buscarUsuariosCriadosApos(LocalDateTime data) {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.dataHoraCriacao > :data", Usuario.class);
        query.setParameter("data", data);
        return query.getResultList();
    }
}
