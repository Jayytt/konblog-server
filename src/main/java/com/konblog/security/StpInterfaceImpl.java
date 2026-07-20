package com.konblog.security;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        SaSession s = StpUtil.getSessionByLoginId(loginId);
        return s == null ? new ArrayList<>() : s.get("permissions", ArrayList::new);
    }
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        SaSession s = StpUtil.getSessionByLoginId(loginId);
        return s == null ? new ArrayList<>() : s.get("roles", ArrayList::new);
    }
}