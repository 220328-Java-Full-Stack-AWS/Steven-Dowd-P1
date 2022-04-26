package models;

import java.sql.Timestamp;

public class ReimbModel {
/*
    create table if not exists ers_reimb (
    reimb_id serial primary key,
    reimb_amount decimal(8,2),
    reimb_submitted timestamp,
    reimb_resolved timestamp,
    reimb_description varchar(250),
    reimb_author int,
    reimb_resolver int,
    reimb_status_id int,
    reimb_type_id int,
*/
    int reimbId;
    float reimbAmount;
    Timestamp reimbSubmitted;
    Timestamp reimbResolved;
    String reimbDescription;
    int reimbAuthor;
    int reimbResolver;
    int reimbStatusId;
    int reimbTypeId;

    public ReimbModel() {
    }

    public ReimbModel(float reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbDescription, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimbTypeId) {
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public float getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(float reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Timestamp getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(Timestamp reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public Timestamp getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(Timestamp reimResolved) {
        this.reimbResolved = reimResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public int getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(int reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public int getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(int reimbResolver) {
        this.reimbResolver = reimbResolver;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public int getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(int reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    @Override
    public String toString() {
        return "ReimbModel{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimResolved=" + reimbResolved +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbAuthor=" + reimbAuthor +
                ", reimbResolver=" + reimbResolver +
                ", reimbStatusId=" + reimbStatusId +
                ", reimbTypeId=" + reimbTypeId +
                '}';
    }
}
