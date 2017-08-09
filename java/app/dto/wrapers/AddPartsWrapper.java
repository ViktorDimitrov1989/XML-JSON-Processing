package app.dto.wrapers;

import app.dto.add.AddPartDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "parts")
public class AddPartsWrapper {
    @XmlElement(name = "part")
    private List<AddPartDto> parts;

    public AddPartsWrapper() {
    }

    public List<AddPartDto> getParts() {
        return parts;
    }

    public void setParts(List<AddPartDto> parts) {
        this.parts = parts;
    }
}
