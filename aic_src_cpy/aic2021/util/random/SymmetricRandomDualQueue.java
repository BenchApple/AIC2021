// 
// Decompiled by Procyon v0.5.36
// 

package aic2021.util.random;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricRandomDualQueue
{
    Queue<Double> randomQueueA;
    Queue<Double> randomQueueB;
    
    public SymmetricRandomDualQueue() {
        this.randomQueueA = new LinkedList<Double>();
        this.randomQueueB = new LinkedList<Double>();
    }
    
    Double poll(final SymmetricEnum symmetricEnum) {
        if (symmetricEnum == SymmetricEnum.NON_SYMMETRIC) {
            if (this.randomQueueA.size() > 0) {
                return this.randomQueueA.poll();
            }
            final Double random = CustomRandom.getInstance().getRandom();
            this.randomQueueB.add(random);
            return random;
        }
        else {
            if (this.randomQueueB.size() > 0) {
                return this.randomQueueB.poll();
            }
            final Double random2 = CustomRandom.getInstance().getRandom();
            this.randomQueueA.add(random2);
            return random2;
        }
    }
}
