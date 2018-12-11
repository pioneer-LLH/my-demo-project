package llh.demo;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperTest {
	// �Ự��ʱʱ�䣬����Ϊ��ϵͳĬ��ʱ��һ��
		private final static int SESSION_TIMEOUT = 30000;
		
		//����zookeeperʵ��
		ZooKeeper zk;
		
		//����watchʵ��
		Watcher wa = new Watcher(){
			public void process(WatchedEvent event){
				System.out.print(event.toString());
			}
		};
		
		//��ʼ��zookeeperʵ��
		private void createZkInstance() throws IOException{
			zk = new ZooKeeper("localhost:2181",ZookeeperTest.SESSION_TIMEOUT , this.wa);
		}
		
		private void ZKOptions() throws KeeperException, InterruptedException{
			System.out.println("/n1. ���� ZooKeeper �ڵ� (znode �� zoo2, ���ݣ� myData2 ��Ȩ�ޣ�OPEN_ACL_UNSAFE ���ڵ����ͣ� Persistent");
			zk.create("/zoo2","myData2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println("/n2. �鿴�Ƿ񴴽��ɹ��� ");
			System.out.println(new String(zk.getData("/zoo2",false,null)));
			System.out.println("/n3. �޸Ľڵ����� ");
			zk.setData("/zoo2", "shenlan211314".getBytes(), -1);
			System.out.println("/n4. �鿴�Ƿ��޸ĳɹ��� ");
			System.out.println(new String(zk.getData("/zoo2", false, null)));
			System.out.println("/n5. ɾ���ڵ� ");
			zk.delete("/zoo2", -1);
			System.out.println("/n6. �鿴�ڵ��Ƿ�ɾ���� ");
			System.out.println(" �ڵ�״̬�� ["+zk.exists("/zoo2", false)+"]");
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
