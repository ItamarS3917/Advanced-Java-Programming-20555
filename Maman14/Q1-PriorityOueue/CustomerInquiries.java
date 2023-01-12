public class CustomerInquiries {
    private String customerName;
    private long customerId;
    private String referenceDetails;

    public CustomerInquiries(String customerName, long customerId, String referenceDetails) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.referenceDetails = referenceDetails;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CustomerInquiries) {
            CustomerInquiries other = (CustomerInquiries) obj;
            return this.customerId == other.customerId && this.referenceDetails.equals(other.referenceDetails);
        }
        return false;
    }

    public String toString() {
        return "Request of: " + customerName + ". ID number: " + customerId + ". The request: " + referenceDetails;
    }
}
