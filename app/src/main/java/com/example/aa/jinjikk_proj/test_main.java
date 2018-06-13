package com.example.aa.jinjikk_proj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class test_main extends  AppCompatActivity {

    TextView score_tv, time_tv, notify;


    Button button[] = new Button[9];
    int data[] = new int[9];
    int stage = 1;
    int score = 0;

    int index = 0;
    int i;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testpage_main);

        score_tv = (TextView) findViewById(R.id.score_tv);
        time_tv = (TextView) findViewById(R.id.time_tv);
        notify = (TextView) findViewById(R.id.notify);
        j = 0;
        // 시간을 측정할 쓰레드 시작
        //  TimeCountThread timeCountThread = new TimeCountThread();
        // timeCountThread.start();

        button[0] = (Button) findViewById(R.id.button00);
        button[1] = (Button) findViewById(R.id.button01);
        button[2] = (Button) findViewById(R.id.button02);
        button[3] = (Button) findViewById(R.id.button03);
        button[4] = (Button) findViewById(R.id.button04);
        button[5] = (Button) findViewById(R.id.button05);
        button[6] = (Button) findViewById(R.id.button06);
        button[7] = (Button) findViewById(R.id.button07);
        button[8] = (Button) findViewById(R.id.button08);
        setRandomItem();
        // 무작위로 아이템을 배열한다
        // 아이템이 나올 위치를 0에서 8까지 총 9개를 랜덤으로 정하기

    }



    public void setRandomItem() {
        // 위치 정보 초기화
        for (i = 0; i < 9; i++) {
            data[i] = 0;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (j >= (stage * 3)) {
                    button[j].post(new Runnable() {
                        public void run() {
                          reset();
                          notify.setText("Enter button");
                        }
                    });
                    timer.cancel();
                    //timer.cancel();
                } else {
                    Random rand = new Random();
                    index = rand.nextInt(9);
                    if(j>0)
                        if(index==data[j-1])
                            index = index + 1;
                    data[j] = index;
                    button[index].post(new Runnable() {
                        public void run() {
                            if (j > 0)
                                button[data[j - 1]].setBackgroundResource(R.drawable.button);
                            button[index].setBackgroundColor(0xFFFF0000);
                            j++;
                        }
                    });
                }
            }
        }, 500, 500);
    }

    public void reset() {
        for (i = 0; i < 9; i++) {
            button[i].setBackgroundResource(R.drawable.button);
        }
    }
}


    // 버튼을 클릭했을 때 작동할 이벤트 설정
       /* for (i=0; i<9; i++) {
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               //     manageScoreWhenClicks(i);
                }
            });
        }*/

    // 무작위로 아이템을 배치하는 함수





/*
    // 버튼을 클릭했을 때 작동하며 점수를 관리하는 함수
    private void manageScoreWhenClicks(int n) {
        // 빈칸을 클릭하면
        if (status[n] == 0) {
            return;
        }
        // 두더지를 클릭하면
        else if (status[n] == 1) {
            score = score + 5;
        }
        // 차장을 클릭하면
        else if (status[n] == 2) {
            score = score - 10;
        }
        // 부장을 클릭하면
        else {
            score = 0;
        }

        // 점수를 화면에 표시한다
        score_tv.setText(getResources().getString(R.string.score) + score);

        // 무작위로 아이템 배치하기
        setRandomItem();
    }

    // 시간을 관리하는 클래스
    class TimeCountThread extends Thread {

        int time = 30;

        public TimeCountThread() {
            // TimeCountThread 를 등록할 때 쓰임
        }

        public void run() {
            while (time >= 0) {
                if (time == 0) {
                    // MainActivity 에서 점수를 표시하는 다이얼로그를
                    // 띄울 수 있도록 점수 값 전달하고 액티비티 종료
                    Intent intent = getIntent();
                    intent.putExtra("score", score);
                    setResult(0, intent);
                    finish();
                } else {
                    // 시간을 화면에 표시하도록 하는 핸들러 호출
                    timeCountHandler.sendEmptyMessage(time);
                }

                // 시간을 1초 보낸다
                try {
                    Thread.sleep(1000);
                    time--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // 시간을 화면에 표시하는 핸들러
        private Handler timeCountHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                // 시간 표시
                time_tv.setText(getResources().getString(R.string.time) + msg.what);
            }
        };
    }
}*/
