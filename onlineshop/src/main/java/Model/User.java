package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
//import javax.validation.constraints.Size;
//
//import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="User")
public class User {

	@Id 
	@GeneratedValue
	int cusid;
	@Column
	@NotEmpty(message="Please enter UserName")
	String cusName;
		@Column
		int cusPhone;
		@Column
		@NotNull
		@NotEmpty(message="Please enter Address")
		String cusAddr;
		@Column
		@NotNull
		@NotEmpty(message="Please enter Email ID")
		@Email
		String cusEmail;
		@Column
		String role;
		@Column
		@NotNull
		@NotEmpty(message="Please enter Password")
		@Size(min = 6, max = 15)
		String cusPwd;
		
		public User()
		{
			
			/*cusName=null;
			cusPhone=0;
			cusAddr=null;
			cusEmail=null;
			cusPwd=null;*/
			role="ROLE_USER";
		}
		
		
		public String getCusName() {
			return cusName;
		}
		public void setCusName(String cusName) {
			this.cusName = cusName;
		}
		public int getCusPhone() {
			return cusPhone;
		}
		public void setCusPhone(int cusPhone) {
			this.cusPhone = cusPhone;
		}
		public String getCusAddr() {
			return cusAddr;
		}
		public void setCusAddr(String cusAddr) {
			this.cusAddr = cusAddr;
		}
		public String getCusEmail() {
			return cusEmail;
		}
		public void setCusEmail(String cusEmail) {
			this.cusEmail = cusEmail;
		}
		
		public String getCusPwd() {
			return cusPwd;
		}
		public void setCusPwd(String cusPwd) {
			this.cusPwd = cusPwd;
		}
		
		
	}

