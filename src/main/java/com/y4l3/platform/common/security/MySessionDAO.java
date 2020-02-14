package com.y4l3.platform.common.security;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.y4l3.platform.module.sys.entity.SysSession;
import com.y4l3.platform.module.sys.service.SysSessionService;

/**
 * 
 * @author changzhongq
 * @time 2019年3月10日 上午1:08:38
 */
public class MySessionDAO extends CachingSessionDAO {

	@Autowired
	private SysSessionService sysSessionService;

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);

		SysSession sysSession = new SysSession();
		sysSession.setSessionId(sessionId.toString());
		sysSession.setSession(SerializationUtils.serialize(session));
		sysSessionService.save(sysSession);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return (Session) SerializationUtils.deserialize(sysSessionService.find(sessionId).getSession());
	}

	@Override
	protected void doUpdate(Session session) {
		SysSession sysSession = sysSessionService.find(session.getId());
		if (sysSession != null) {
			sysSession.setSession(SerializationUtils.serialize(session));
			sysSessionService.save(sysSession);
		}
	}

	@Override
	protected void doDelete(Session session) {
		sysSessionService.delete(session.getId());
	}

}
