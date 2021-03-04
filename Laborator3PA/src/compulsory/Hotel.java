package compulsory;

import java.time.LocalTime;

public class Hotel extends Location implements Payable, Visitable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    private int rank;

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
}
