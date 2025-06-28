//機能追加
import java.util.Random;
import java.util.Scanner;

public class Sub {

	public static void main(String[] args) {
		Random rand = new Random(); //ランダムな数の生成
		Scanner scanner = new Scanner(System.in); //ユーザーの入力
		
		System.out.println("最小の数を入力してください: "); //ユーザーからminとmaxを受け取って、その範囲でanswerを決める
		int min = Integer.parseInt(scanner.nextLine());
		System.out.println("最大の数を入力してください: ");
		int max = Integer.parseInt(scanner.nextLine());
		
		if (min >= max) {
			System.out.println("最小値は最大値より小さくしてください。");
			scanner.close();
			return;
		}
		
		int answer = rand.nextInt(max - min + 1) + min; //指定範囲
		
		int guess = 0; //ユーザーが入力する予想の数字
		int attempts = 0; 
		final int MAX_ATTEMPTS = 5; //回答の回数制限（5回にした）
		
		System.out.println(min + "～" + max + " の数を当ててください！(最大 " + MAX_ATTEMPTS + " 回まで)");
		
		// 答えが外れていて、かつ回数が残っている間繰り返す
			while (guess != answer && attempts < MAX_ATTEMPTS) {
				System.out.println("あなたの予想: ");
				
				try {
					guess = Integer.parseInt(scanner.nextLine()); //ユーザーが入力した値が文字列として入ってくるのを数値に変換
					attempts++; //ユーザーが回答した回数をカウント
					
					if (guess < answer) {
						System.out.println("もっと大きい数です");
					} else if (guess > answer) {
						System.out.println("もっと小さい数です");
					} else {
						System.out.println("正解！回数: " + attempts);
						break;
					}
					
					//±10以内のヒント
					if (Math.abs(guess - answer) <= 10) {
						System.out.println("おしい！（±10以内）");
					}
					
					// 残り回数表示
					System.out.println("残り回数:" + (MAX_ATTEMPTS - attempts));
					
				} catch (NumberFormatException e) {
					System.out.println("数字を入力してください。");
				}
			} 
			
			if (guess != answer) {
				System.out.println("残念！正解は " + answer + " でした。");
			}
			scanner.close();
	}

}
