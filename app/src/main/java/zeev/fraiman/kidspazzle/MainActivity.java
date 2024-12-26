package zeev.fraiman.kidspazzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {


    int count1=0, id2=0,count=0;
    GridLayout GL_1,GL_2;
    ImageView[] cats=new ImageView[9];
    ImageView[] ans=new ImageView[9];
    int[] pics={R.drawable.image_part_001,R.drawable.image_part_002,
            R.drawable.image_part_003,R.drawable.image_part_004,
            R.drawable.image_part_005,R.drawable.image_part_006,
            R.drawable.image_part_007,R.drawable.image_part_008,
            R.drawable.image_part_009};
    ArrayList<Integer> alPics, alHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alPics=new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            //alPics.add(pics[i]);
            alPics.add(i);
        }
        Collections.shuffle(alPics);

        alHelp=new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            for (int j = 0; j < alPics.size(); j++) {
                if (alPics.get(j)==pics[i])
                    alHelp.add(j);
            }
        }

        GL_1=findViewById(R.id.GL_1);
        for (int i = 0; i < cats.length; i++) {
            cats[i]=new ImageButton(this);
            cats[i].setId(i+100);
            cats[i].setImageResource(pics[alPics.get(i)]);
            cats[i].setOnClickListener(this);
            GL_1.addView(cats[i]);
        }

        GL_2=findViewById(R.id.GL_2);
        for (int i = 0; i < ans.length; i++) {
            ans[i]=new ImageButton(this);
            ans[i].setId(i);
            ans[i].setImageResource(R.drawable.little_cat);
            ans[i].setOnClickListener(this);
            GL_2.addView(ans[i]);
        }
    }

    @Override
    public void onClick(View v) {

        int idv=v.getId();
        if (idv>99) {
            //Toast.makeText(this, "" + alPics.get(idv - 100), Toast.LENGTH_SHORT).show();
        }
        else {
            //Toast.makeText(this, "" + v.getId(), Toast.LENGTH_SHORT).show();
        }

        if (idv<ans.length) {
            id2=v.getId();
            //Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();

        }

        else  {
            int t=idv-100;
            int p=alPics.get(t);
            //Toast.makeText(this, "p="+p, Toast.LENGTH_SHORT).show();
            if (p==id2)
                ans[id2].setImageResource(pics[p]);
        }

    }
}
