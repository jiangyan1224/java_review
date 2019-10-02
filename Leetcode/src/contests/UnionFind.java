package contests;
//并查集，方便管理元素分组，可以查询和合并
public class UnionFind {
    private int[] par;
    private int[] size;

    //构造函数
    public UnionFind(int n){
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
    }

    //查询树的根
    public int find(int x){
        if (par[x]==x) return x;
        else{
            return par[x]=find(par[x]);
        }
    }

    //合并x y所属的集合
    public void union(int x,int y){
        x=find(x);y=find(y);
        if (x==y) return;
        if (size[x]<size[y]){
            par[x]=y;
            size[y]+=size[x];
        }
        else {
            par[y]=x;
            size[x]+=size[y];
        }
    }

    //判断x y是否属于同一个集合
    public boolean same(int x,int y){
        return find(x)==find(y);
    }

}
