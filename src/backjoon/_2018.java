package backjoon;

import java.util.Arrays;
import java.util.Scanner;

//수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
//산술평균 : N개의 수들의 합을 N으로 나눈 값
//중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//최빈값 : N개의 수들 중 가장 많이 나타나는 값
//범위 : N개의 수들 중 최댓값과 최솟값의 차이
//N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
//첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
//둘째 줄에는 중앙값을 출력한다.
//셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
//넷째 줄에는 범위를 출력한다.
public class _2018 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] m = new int[8001];

        int sum = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        int middle = (int) Math.round((double) N / 2);



        int x = 0;
        for (int i = 0; i <N; i++) {
            m[arr[i] + 4000]++;
            x = Math.max(x, m[arr[i] + 4000]);

        }
        int second = 0;
        for (int i = 0; i < m.length; i++) {// -4000(+4000) ~ 4000(+4000)

            if (m[i] == x) {
                count++;
                second = i - 4000;

            }
            if (count == 2) {
                second = i - 4000;
                break;
            }

        }

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= max) {
                max = arr[i];
            }

        }
        for (int i = 0; i <= N - 1; i++) {
            if (arr[i] <= min) {
                min = arr[i];
            }
        }

        System.out.println((int) Math.round((double) sum / (double) N));
        if (N % 2 == 0) {
            System.out.println(((arr[middle - 1] + arr[middle]) / 2) + 1);
        } else
            System.out.println(arr[middle - 1]);
        System.out.println(second);
        System.out.println(max - min);
    }

}