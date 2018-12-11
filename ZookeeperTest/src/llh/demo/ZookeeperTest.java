package llh.demo;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperTest {
	// 会话超时时间，设置为与系统默认时间一致
		private final static int SESSION_TIMEOUT = 30000;
		
		//创建zookeeper实例
		ZooKeeper zk;
		
		//创建watch实例
		Watcher wa = new Watcher(){
			public void process(WatchedEvent event){
				System.out.print(event.toString());
			}
		};
		
		//初始化zookeeper实例
		private void createZkInstance() throws IOException{
			zk = new ZooKeeper("localhost:2181",ZookeeperTest.SESSION_TIMEOUT , this.wa);
		}
		
		private void ZKOptions() throws KeeperException, InterruptedException{
			System.out.println("/n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限：OPEN_ACL_UNSAFE ，节点类型： Persistent");
			zk.create("/zoo2","myData2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println("/n2. 查看是否创建成功： ");
			System.out.println(new String(zk.getData("/zoo2",false,null)));
			System.out.println("/n3. 修改节点数据 ");
			zk.setData("/zoo2", "shenlan211314".getBytes(), -1);
			System.out.println("/n4. 查看是否修改成功： ");
			System.out.println(new String(zk.getData("/zoo2", false, null)));
			System.out.println("/n5. 删除节点 ");
			zk.delete("/zoo2", -1);
			System.out.println("/n6. 查看节点是否被删除： ");
			System.out.println(" 节点状态： ["+zk.exists("/zoo2", false)+"]");
		}
		
		private void ZKClose() throws InterruptedException{
			zk.close();
		}
		
		/**
		 * @param args
		 * @author ll
		 * @throws IOException 
		 * @throws InterruptedException 
		 * @throws KeeperException 
		 * @category zookeeper
		 */
		public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
			ZookeeperTest z = new ZookeeperTest();
			z.createZkInstance();
			z.ZKOptions();
			z.ZKClose();
		}

}
