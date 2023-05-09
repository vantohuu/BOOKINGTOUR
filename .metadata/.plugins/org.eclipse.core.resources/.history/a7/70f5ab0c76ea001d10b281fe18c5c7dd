package BOOKINGTOUR.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Embeddable
class CTDiemDuLichPK implements Serializable {
	@ManyToOne
    private Tour tour;
	 @ManyToOne
	    private DiemDuLich diemDuLich;}

@Entity
@Table(name="CTDIEMDULICH")
public class CTDiemDuLich {
	@Id
    @EmbeddedId
    private CTDiemDuLichPK pk;
	
}
