import java.util.Scanner;

class Process {
    int processId, burstTime, remainingTime;
    Process next;

    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        System.out.println("Process " + processId + " added with burst time " + burstTime);
    }

    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalTime = 0, completedProcesses = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;
        Process current = head;

        while (completedProcesses < getProcessCount()) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(current.remainingTime, timeQuantum);
                totalTime += executionTime;
                current.remainingTime -= executionTime;

                System.out.println("Executing Process " + current.processId + " for " + executionTime + " units.");

                if (current.remainingTime == 0) {
                    completedProcesses++;
                    int turnaroundTime = totalTime;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process " + current.processId + " completed. Turnaround Time: " + turnaroundTime
                            + ", Waiting Time: " + waitingTime);
                    removeProcess(current.processId);
                }
            }
            current = current.next;
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / completedProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / completedProcesses);
    }

    public void removeProcess(int processId) {
        if (head == null)
            return;

        Process current = head, prev = tail;

        do {
            if (current.processId == processId) {
                if (current == head)
                    head = head.next;
                if (current == tail)
                    tail = prev;
                prev.next = current.next;

                if (current == head && current.next == head) {
                    head = tail = null;
                }

                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public int getProcessCount() {
        if (head == null)
            return 0;

        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        scheduler.simulateScheduling();
    }
}
