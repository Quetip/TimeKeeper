package sample;

import javax.management.timer.Timer;

public class CountTime {
    private final long createdMillis = System.currentTimeMillis();

    public int getAgeInSeconds() {

        long nowMillis = System.currentTimeMillis();
        return (int)((nowMillis - this.createdMillis) / 1000);
    }
}
