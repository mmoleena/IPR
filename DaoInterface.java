package com.ecable.daoI;
import java.util.Vector;
import com.ecable.bean.DistrictTO;
public interface DistrictDaoI {
public boolean insertDistrict(DistrictTO dt);
public Vector<DistrictTO> viewDist();
public DistrictTO viewDistAt( int did);
public boolean deleteDist(int did);
public boolean updateDist(DistrictTO dt);
public Vector<DistrictTO> getDistName(String sname);
}