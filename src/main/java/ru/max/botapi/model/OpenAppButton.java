package ru.max.botapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Objects;

public class OpenAppButton extends Button implements MaxSerializable {

    @Nullable
    private @Valid String webApp;

    @Nullable
    private @Valid Long contactId;

    @Nullable
    @Size(max = 512)
    private @Valid String payload;

    @JsonCreator
    public OpenAppButton(@JsonProperty("text") String text) {
        super(text);
    }

    public OpenAppButton webApp(@Nullable String webApp) {
        this.setWebApp(webApp);
        return this;
    }

    @Nullable
    @JsonProperty("web_app")
    public String getWebApp() {
        return webApp;
    }

    public void setWebApp(@Nullable String webApp) {
        this.webApp = webApp;
    }

    public OpenAppButton contactId(@Nullable Long contactId) {
        setContactId(contactId);
        return this;
    }

    @Nullable
    @JsonProperty("contact_id")
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(@Nullable Long contactId) {
        this.contactId = contactId;
    }

    public OpenAppButton payload(@Nullable String payload) {
        setPayload(payload);
        return this;
    }

    @Nullable
    @JsonProperty("payload")
    public String getPayload() {
        return payload;
    }

    public void setPayload(@Nullable String payload) {
        this.payload = payload;
    }

    @Override
    public String getType() {
        return Button.OPEN_APP;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OpenAppButton that = (OpenAppButton) o;
        return Objects.equals(webApp, that.webApp) && Objects.equals(contactId, that.contactId) && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), webApp, contactId, payload);
    }

    @Override
    public String toString() {
        return "OpenAppButton{" + super.toString()
                + " webApp='" + webApp + '\''
                + " contactId='" + contactId + '\''
                + " payload='" + payload + '\''
                + '}';
    }
}
