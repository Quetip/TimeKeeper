package sample;

import javax.management.timer.Timer;

public class CountTimeInMilis {
    private final long createdMillis = System.currentTimeMillis();

    public void TotalTimes(int subTotalTimes) {
        subTotalTimes += subTotalTimes;
        System.out.println("Subtotaled Times: " + subTotalTimes);
    }

    public int getAgeInSeconds() {
        long nowMillis = System.currentTimeMillis();
        int subTotalTimes = (int)((nowMillis - this.createdMillis) / 1000);
        TotalTimes(subTotalTimes);
        return subTotalTimes;
    }

}
