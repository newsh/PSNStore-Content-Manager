package de.newsh.title.model;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.newsh.util.LocalDateAdapter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Title {

	private final StringProperty storeUrl;
    private final StringProperty name;
    private final StringProperty platform;
    private final StringProperty price;
    private final ObjectProperty<LocalDate> releaseDate;
    @Override
    public String toString() {
    	StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");
        
        result.append(this.getClass().getName() + " Object {" + NL);
        result.append(" Name: " + name + NL);
        result.append(" storeUrl: " + storeUrl+ NL);
        result.append(" Platform: " + platform+ NL);
        result.append(" price: " + price + NL );
        result.append(" releaseDate: " + releaseDate + NL);
        result.append("}");

        return result.toString();	
    }
    /**
     * Default constructor.
     */
    public Title() {
    	this.name = new SimpleStringProperty("");
        this.platform = new SimpleStringProperty("");
        this.price = new SimpleStringProperty("");
        this.releaseDate = new SimpleObjectProperty<LocalDate>();
        this.storeUrl = new SimpleStringProperty("");
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
    
    public StringProperty nameProperty() {
        return name;
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform) {
        this.platform.set(platform);
    }
    
    public StringProperty platformProperty() {
        return platform;
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
    
    public StringProperty priceProperty() {
        return price;
    }
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getReleaseDate() {
    	return releaseDate.get();
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate.set(releaseDate);
    }
    
    public String getStoreUrl() {
		return storeUrl.get();
	}
    
    public String getCID() {
    	return this.getStoreUrl().substring(this.getStoreUrl().lastIndexOf("/")+1).trim();
    }
    
	public void setStoreUrl(String storeUrl) {
		this.storeUrl.set(storeUrl);
	}
	public ObjectProperty<LocalDate> releaseDateProperty() {
        return releaseDate;
    }
    
}