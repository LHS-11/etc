package bridge;

import bridge.model.BridgeComparator;
import bridge.model.BridgeMaker;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final BridgeComparator bridgeComparator;
    private int location;
    private int retryCount;

    public BridgeGame(int size){
        this.location=-1;
        this.retryCount=1;
        BridgeMaker bridgeMaker =new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge=bridgeMaker.makeBridge(size);
        bridgeComparator = new BridgeComparator();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String moving) {
        location+=1;
        String result = bridgeComparator.compareBridge(bridge, moving, location);
        return location;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    public int countRetry(){
        retryCount+=1;
        return retryCount;
    }

}
