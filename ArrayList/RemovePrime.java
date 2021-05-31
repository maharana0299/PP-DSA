package ArrayList;

import java.util.*;

public class RemovePrime {

	public static void solution(ArrayList<Integer> ls){
		List<Integer> primes = new ArrayList<>();

        for(int i : ls){
            if (!isPrime_(i)){
                primes.add(i);
            }
        }
        System.out.println(primes.toString());
	}
	
	public static boolean isPrime_(int n) {
        for (int i = 2; i*i <= n; i++)  {
            if (n % i == 0) {
                return false;
            }
        } 
        return true;
     }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
// 		System.out.println(al);
	}

}