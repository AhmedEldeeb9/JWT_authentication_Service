package com.vodafone.collection.auth.config;

import java.util.Hashtable;


public class SMCacher<K, V> implements Runnable {

	/**
	 * 
	 */
	long KeepLifeFor;
	Thread CleanThread;

	public SMCacher(long KeepLifeFor /* Keep Life by MSec */) {
		this.KeepLifeFor = KeepLifeFor;
	}

	private Hashtable<K, SMCacherStorInformation<V>> Storge = new Hashtable<K, SMCacherStorInformation<V>>();

	public synchronized void put(K paramK, V paramV) {
		Storge.put(paramK, new SMCacherStorInformation<V>(paramV));
		if (CleanThread == null) {
			CleanThread = new Thread(this);
			CleanThread.start();
		}

	}

	public synchronized V IsExist(K paramK) {
		SMCacherStorInformation<V> info = Storge.get(paramK);
		if (info == null) {
			return null;
		} else {
			return info.paramV;
		}
	}

	public synchronized V get(K paramK) {
		SMCacherStorInformation<V> info = Storge.get(paramK);
		if (info == null) {
			return null;
		} else {
			info.LastAccessTime = System.currentTimeMillis();
			return info.paramV;
		}
	}

	@Override
	public void run() {

		try {
			while (true) {
				CleanThread.setName("SMCacher");
				while (true) {
					CleanThread.sleep(10 * KeepLifeFor);
					DoCleanCheck();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CleanThread = null;
	}

	public synchronized void remove(K paramK) {
		Storge.remove(paramK);
	}

	@SuppressWarnings("rawtypes")
	private void DoCleanCheck() throws Exception {
		long currentTime = System.currentTimeMillis();
		Object[] Keys = Storge.keySet().toArray();
		if (Keys != null) {
			for (Object Key : Keys) {
				SMCacherStorInformation info = Storge.get(Key);
				if (currentTime - info.LastAccessTime > KeepLifeFor) {
					// Expire
					Storge.remove(Key);
				}

			}
		}

	}

}
