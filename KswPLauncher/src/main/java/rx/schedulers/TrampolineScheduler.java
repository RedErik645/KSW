package rx.schedulers;

import rx.Scheduler;

@Deprecated
public final class TrampolineScheduler extends Scheduler {
    private TrampolineScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return null;
    }
}
