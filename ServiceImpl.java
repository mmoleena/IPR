package com.ecable.serviceImpl;
import java.util.Vector;
import com.ecable.bean.DistrictTO;
import com.ecable.daoI.DistrictDaoI;
import com.ecable.daoImpl.DistrickDaoImpl;
import com.ecable.exception.ConnectionException;
import com.ecable.exception.DataNotFoundException;
import com.ecable.exception.LoginException;
import com.ecable.serviceI.DistrictServiceI;
public class DistrictServiceImpl implements DistrictServiceI{
DistrictDaoI daoi=new DistrickDaoImpl();
public boolean insertDistrict(DistrictTO dt)throws
LoginException,ConnectionException{
return daoi.insertDistrict(dt);
}
public Vector<DistrictTO> viewDist()throws
ConnectionException,DataNotFoundException{
return daoi.viewDist();
}
public DistrictTO viewDistAt( int did)throws
ConnectionException,DataNotFoundException{
return daoi.viewDistAt(did);
}
public boolean deleteDist(int did)throws ConnectionException{
return daoi.deleteDist(did);
}
public boolean updateDist(DistrictTO dt)throws ConnectionException{
    return daoi.updateDist(dt);
}
public Vector<DistrictTO> getDistName(String sname)throws
ConnectionException,DataNotFoundException{
return daoi.getDistName(sname);
}
}
