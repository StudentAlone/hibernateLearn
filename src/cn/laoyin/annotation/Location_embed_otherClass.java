package cn.laoyin.annotation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * ע��ʵ����  ע�������������Ϊ��
 * @author Administrator
 */
@Entity  
@Table(name="t_location",schema="hibernate_demo")  
public class Location_embed_otherClass {
	    @Id  
	    @GeneratedValue(generator="provinceId")  
	    @GenericGenerator(name="provinceId",strategy="assigned")  
	    private String provinceId;  
	    private String provinceName;  
	    //ע��Ҫ���õ���  :ע����������ԣ�city.Column������Ϊ�У����Ӹ�ע�⣬���ݿ��е����� city
	    @Embedded  
	    private City city;  
	    public Location_embed_otherClass() {  
	        // TODO Auto-generated constructor stub  
	    }  
	    public Location_embed_otherClass(String provinceId, String provinceName, City city) {  
	        super();  
	        this.provinceId = provinceId;  
	        this.provinceName = provinceName;  
	        this.city = city;  
	    }  
	    public String getProvinceId() {  
	        return provinceId;  
	    }  
	    public void setProvinceId(String provinceId) {  
	        this.provinceId = provinceId;  
	    }  
	    public String getProvinceName() {  
	        return provinceName;  
	    }  
	    public void setProvinceName(String provinceName) {  
	        this.provinceName = provinceName;  
	    }  
	    public City getCity() {  
	        return city;  
	    }  
	    public void setCity(City city) {  
	        this.city = city;  
	    }  
}
