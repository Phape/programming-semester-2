package programming_2.exercise_13;

class KonzertDaten {
    private int sitzPlatz = 0;
    synchronized int freierPlatz() { //hier wurde synchronized eingefügt
        int n = sitzPlatz;
        long t = System.currentTimeMillis() + 50, s = t + 50;
        while (System.currentTimeMillis() < t) /* simuliere einen Datenbankzugriff */ ;
        Thread.yield();
        // erlaube Aktivitäten anderer Threads
        while (System.currentTimeMillis() < s)
            /* simuliere einen Datenbankzugriff */ ;
        return sitzPlatz = n + 1;
    }
}

