import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DisjointSet {

    List<Integer> size;
    List<Integer> parent;

    public DisjointSet(int n){

        size = new ArrayList<Integer>();
        parent = new ArrayList<Integer>();

        for(int i=0;i<=n;i++){

            size.add(1);
            parent.add(i);

        }

    }

    public int findUPar(int node){

        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);

    }

    public void unionBySize(int u , int v){

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_v) + size.get(ulp_u));
        }

        else{
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }

    }
}

public class AccountsMerge {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        Map<String , Integer> mpp = new HashMap<String , Integer>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){

                String mail = accounts.get(i).get(j);

                if(!mpp.containsKey(mail)){
                    mpp.put(mail , i);
                }

                else{
                    ds.unionBySize(i , mpp.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for(int i=0;i<n;i++){
            mergedMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String , Integer> it : mpp.entrySet()){

            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);

        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){

            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<String>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);

        }

        return ans;

    }
}
