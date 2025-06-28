import java.util.Random;
import java.util.Scanner;

public class Sub {

	public static void main(String[] args) {
		Random rand = new Random(); //ランダムな数の生成
		Scanner scanner = new Scanner(System.in); //ユーザーの入力
		int answer = rand.nextInt(100) + 1; //1～１００の乱数　プログラム側（コンピュータ）がランダムに決定
		
		System.out.println("1〜100の数を当ててください！");
		
		int guess = 0; //ユーザーが入力する予想の数字
		int attempts = 0; //
		
		
			while (guess != answer) {
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
					}
				} catch (NumberFormatException e) {
					System.out.println("数字を入力してください。");
				}
			} 
			scanner.close();
	}

}
