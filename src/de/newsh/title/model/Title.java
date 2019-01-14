
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
		result.append(" storeUrl: " + storeUrl + NL);
		result.append(" Platform: " + platform + NL);
		result.append(" price: " + price + NL);
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
		return this.getStoreUrl().substring(this.getStoreUrl().lastIndexOf("/") + 1).trim();
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl.set(storeUrl);
	}

	public ObjectProperty<LocalDate> releaseDateProperty() {
		return releaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.get().hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.get().hashCode());
		result = prime * result + ((price == null) ? 0 : price.get().hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.get().hashCode());
		result = prime * result + ((storeUrl == null) ? 0 : storeUrl.get().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.get().equals(other.name.get()))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.get().equals(other.platform.get()))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.get().equals(other.price.get()))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.get().equals(other.releaseDate.get()))
			return false;
		if (storeUrl == null) {
			if (other.storeUrl != null)
				return false;
		} else if (!storeUrl.get().equals(other.storeUrl.get()))
			return false;
		return true;
	}

}