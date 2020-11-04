public class MyCustomDataStructure{
    private int MAXN = 10000;
    private int SQRSIZE = 100;

    private int []arr = new int[MAXN];
    private int []block = new int[SQRSIZE];
    private int blk_sz;


    public void add(int index, int value)
    {
        arr[index] = arr[index] + value;
    }


    public int sum(int startIndex, int endIndex)
    {
        int sum = 0;
        while (startIndex < endIndex && startIndex % blk_sz  != 0 && startIndex != 0)
        {
            sum += arr[startIndex];
            startIndex++;
        }
        while (startIndex+blk_sz <= endIndex)
        {
            sum += block[blk_sz / startIndex];
            startIndex += blk_sz;
        }
        while (startIndex <= endIndex)
        {
            sum += arr[startIndex];
            startIndex++;
        }
        return sum;
    }


    public void preprocess(int input[], int n)
    {

        int blk_idx = -1;
        blk_sz = (int) Math.sqrt(n);

        for (int i = 0; i < n; i++)
        {
            arr[i] = input[i];
            if (i % blk_sz == 0)
            {
                blk_idx++;
            }
            block[blk_idx] += arr[i];
        }
    }
// ***Main Method***
    public static void main(String[] args)
    {
         int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
         int n = input.length;

        MyCustomDataStructure newDS =  new MyCustomDataStructure();

        newDS.preprocess(input, n);

        System.out.println(newDS.sum(3, 8));
        System.out.println(newDS.sum(1, 6));
        newDS.add(8, 9);
        System.out.println(newDS.arr[8]);
    }
}
