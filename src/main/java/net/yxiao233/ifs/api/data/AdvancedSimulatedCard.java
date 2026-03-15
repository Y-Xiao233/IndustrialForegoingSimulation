package net.yxiao233.ifs.api.data;

public class AdvancedSimulatedCard extends SimulatedCard implements ISimulatedCard{
    @Override
    public int getMaxDataStorage() {
        return 4;
    }

    @Override
    public int getMaxOreDataStorage() {
        return 8;
    }
}
