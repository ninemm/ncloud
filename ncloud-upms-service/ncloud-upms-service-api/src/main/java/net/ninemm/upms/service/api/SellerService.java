package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.Operation;
import net.ninemm.upms.service.model.Seller;

import java.util.Map;

public interface SellerService {

    public Page<Seller> paginate(int pageNumber, int pageSize, Map<String, Object> params);

    /**
     * delete model by primary key
     *
     * @param id
     * @return success
     */
    public boolean deleteById(Object id);

    public Seller findById(Object id);

    public boolean update(Seller seller);

    public Object save(Seller seller);
}
