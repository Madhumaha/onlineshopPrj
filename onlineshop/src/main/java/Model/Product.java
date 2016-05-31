package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")

public class Product implements Serializable {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
int id;
	@NotNull
	@NotEmpty
String productname;
	@NotNull
	@NotEmpty
String description;
	int price;
	@Transient
MultipartFile image;
/*public Product()
{
	id=0;
	productname=null;
	description=null;
	price=0;
}
public Product(int id,String pname,String desc,int pr)
{
	this.id=id;
	this.productname=pname;
	this.description=desc;
	this.price=pr;
}*/

public void setImage(MultipartFile image)
{
	this.image=image;
}
public MultipartFile getImage()
{
	return this.image;
}
public void setId(int id)
{
	this.id=id;
}
public int getId()
{
	return this.id;
}
public void setproductname(String pname)
{
	this.productname=pname;
}
public String getproductname()
{
	return this.productname;
}
public void setDescription(String desc)
{
	this.description=desc;
}
public String getDescription()
{
	return this.description;
}
public void setPrice(int pr)
{
	this.price=pr;
}
public int getPrice()
{
	return this.price;
}
@Override
public String toString() {
	return "Product[ id="+id+", productname="+productname+
			",description="+ description+",price="+price+"]";
}
}
