package com.ecable.delegate;
import java.util.Vector;
import com.ecable.exception.ConnectionException;
import com.ecable.exception.DataNotFoundException;
import com.ecable.exception.LoginException;
import com.ecable.bean.DistrictTO;
import com.ecable.serviceI.DistrictServiceI;
import com.ecable.serviceImpl.DistrictServiceImpl;
public class DistrictMgrDelegate {
DistrictServiceI dsi=new DistrictServiceImpl();
public boolean insertDistrict(DistrictTO dt) throws LoginException,
ConnectionException{
    return dsi.insertDistrict(dt);
}
public Vector<DistrictTO> viewDist() throws ConnectionException,
DataNotFoundException{
return dsi.viewDist();
}
public DistrictTO viewDistAt( int did) throws ConnectionException,
DataNotFoundException{
return dsi.viewDistAt(did);
}
public boolean deleteDist(int did) throws ConnectionException{
return dsi.deleteDist(did);
}
public boolean updateDist(DistrictTO dt) throws ConnectionException{
return dsi.updateDist(dt);
}
public Vector<DistrictTO> getDistName(String sname) throws ConnectionException,
DataNotFoundException{
return dsi.getDistName(sname);
}
}
