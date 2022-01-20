package mon.projet.entities;

import java.io.Serializable; 
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Position
 *
 */
@Entity

public class Position implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double latitude;
	private double longitude;
	private Date date;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JoinColumn(name = "smartphone_id")
	private SmartPhone smartphone;

	public Position() {
		super();
	}   

	public Position(int id, double latitude, double longitude, Date date, SmartPhone smartphone) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.smartphone = smartphone;
	}

	public Position(int id, double latitude, double longitude, Date date) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
	}

	public Position(double latitude, double longitude, Date date, SmartPhone smartphone) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.smartphone = smartphone;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}   
	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SmartPhone getSmartphone() {
		return smartphone;
	}

	public void setSmartphone(SmartPhone smartphone) {
		this.smartphone = smartphone;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", date=" + date
				+ ", smartphone=" + smartphone + "]";
	}
   
}
