package br.com.dataflow.pharmanager.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;
import br.com.dataflow.pharmanager.model.Usuario;

/**
 * Repositório responsável pelas operações de persistência e consultas relacionadas a usuários.
 */
public class UsuarioRepository {
    private final EntityManager entityManager;

    /**
     * Construtor do UsuarioRepository.
     *
     * @param entityManager O EntityManager responsável pelo gerenciamento das entidades.
     */
    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Verifica se o nome de usuário já está cadastrado.
     *
     * @param usuario O nome de usuário a ser verificado.
     * @return {@code true} se o usuário já existir, caso contrário {@code false}.
     */
    private boolean usuarioJaExiste(String usuario) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.usuario = :usuario", Long.class);
        query.setParameter("usuario", usuario);
        return query.getSingleResult() > 0;
    }

    /**
     * Valida os dados de um usuário antes de salvar ou atualizar.
     *
     * @param usuario O usuário a ser validado.
     * @param isAtualizacao Indica se é uma atualização ({@code true}) ou um novo cadastro ({@code false}).
     * @throws IllegalArgumentException Se algum campo obrigatório for inválido ou se o nome de usuário já estiver em uso.
     */
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

        if (!isAtualizacao && usuarioJaExiste(usuario.getUsuario())) {
            throw new IllegalArgumentException("O nome de usuário já está em uso.");
        }

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

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param usuario O usuário a ser salvo.
     */
    public void salvar(Usuario usuario) {
        validarUsuario(usuario, false);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar o usuário: " + e.getMessage(), e);
        }
    }

    /**
     * Atualiza um usuário existente no banco de dados.
     *
     * @param usuario O usuário a ser atualizado.
     */
    public void atualizar(Usuario usuario) {
        validarUsuario(usuario, true);
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar o usuário: " + e.getMessage(), e);
        }
    }

    /**
     * Lista todos os usuários cadastrados.
     *
     * @return Uma lista de todos os usuários.
     */
    public List<Usuario> listarTodos() {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id O ID do usuário a ser buscado.
     * @return O usuário correspondente ao ID ou {@code null} se não encontrado.
     */
    public Usuario buscarPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    /**
     * Busca um usuário pelo nome de usuário.
     *
     * @param usuario O nome de usuário.
     * @return O usuário correspondente ou {@code null} se não encontrado.
     */
    public Usuario buscarPorUsuario(String usuario) {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.usuario = :usuario", Usuario.class);
        query.setParameter("usuario", usuario);
        List<Usuario> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    /**
     * Exclui um usuário pelo ID.
     *
     * @param id O ID do usuário a ser excluído.
     */
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

    /**
     * Busca usuários que estão ativos.
     *
     * @return Uma lista de usuários ativos.
     */
    public List<Usuario> buscarUsuariosAtivos() {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.estado = true", Usuario.class);
        return query.getResultList();
    }

    /**
     * Busca usuários que estão inativos.
     *
     * @return Uma lista de usuários inativos.
     */
    public List<Usuario> buscarUsuariosInativos() {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.estado = false", Usuario.class);
        return query.getResultList();
    }

    /**
     * Busca usuários cadastrados após uma determinada data e hora.
     *
     * @param data A data e hora de corte para a busca.
     * @return Uma lista de usuários cadastrados após a data especificada.
     */
    public List<Usuario> buscarUsuariosCriadosApos(LocalDateTime data) {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.dataHoraCriacao > :data", Usuario.class);
        query.setParameter("data", data);
        return query.getResultList();
    }
}
