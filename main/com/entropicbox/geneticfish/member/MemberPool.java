package com.entropicbox.geneticfish.member;

import com.entropicbox.geneticfish.world.World;

public class MemberPool {
	private Member[] pool;

	public MemberPool(int numMembers) {
		pool = new Member[numMembers];
	}

	public int getNumMembers() {
		return pool.length;
	}

	public void setMember(Member member, int i) {
		pool[i] = member;
	}

	public Member getMember(int i) {
		return pool[i];
	}

	//	Most fit will be first [0] and least fit will be last [numMembers-1]
	public void sortMemberPoolByFitnessInWorld(World worldState) {
		// fuckit, bubblesort
		//	TODO: unfuckit
		int n = this.pool.length;
		Member temp = null;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				//	If the 'i' element is bigger than the 'j' element (based on world fitness)
				if (this.pool[j - 1].compareToInWorld(this.pool[j], worldState) < 1) {
					// swap elements
					temp = this.pool[j - 1];
					this.pool[j - 1] = this.pool[j];
					this.pool[j] = temp;
				}

			}
		}

	}

}
