package com.qf.repositroy;

import com.qf.domain.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2019/11/27.
 */
public interface UserinfoRepository extends JpaRepository<Userinfo, Integer> {
}
