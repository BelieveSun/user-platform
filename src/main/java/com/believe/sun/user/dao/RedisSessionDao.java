package com.believe.sun.user.dao;

import com.believe.sun.user.model.Role;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by sungj on 17-6-26.
 */
@Repository
public class RedisSessionDao extends AbstractSessionDAO implements CrudRepository<Session,String> {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    @Autowired
    public void setSessionIdGenerator(SessionIdGenerator sessionIdGenerator) {
        super.setSessionIdGenerator(sessionIdGenerator);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = session.getId();
        if (sessionId == null) {
            sessionId = this.generateSessionId(session);
            this.assignSessionId(session, sessionId);
        }
        this.save(session);
        return sessionId;
    }


    @Override
    protected Session doReadSession(Serializable sessionId) {
        this.findOne(sessionId.toString());
        return null;

    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }

    @Override
    public Session save(Session s) {
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        String key = "shiro:auth:session:"+s.getId();
        operations.set(key,s,120000);
        return s;
    }

    @Override
    public <S extends Session> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Session findOne(String s) {
        String key = "shiro:auth:session:"+s;
        ValueOperations<Object, Object> objectObjectValueOperations = redisTemplate.opsForValue();
        Object o = objectObjectValueOperations.get(s);
        return (Session)o;
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public Iterable<Session> findAll() {
        return null;
    }

    @Override
    public Iterable<Session> findAll(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String s) {

    }


    @Override
    public void delete(Iterable<? extends Session> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
