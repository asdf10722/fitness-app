package com.example.yinhen.project1;

/**
 * Created by Ray on 2017/12/4.
 */

public class Utils {

    public static int trainingTypeToImageDrawableID(String type) {
        switch (type) {
            case "伏地挺身":
                return R.drawable.push_ups;
            case "仰臥起坐":
                return R.drawable.sit_ups;
            case "仰臥舉腿":
                return R.drawable.supine_lift_legs;
            case "俯臥撐":
                return R.drawable.tilting_support;
            case "側躺抬腿":
                return R.drawable.lying_on_the_side_legs;
            case "屈膝禮弓步":
                return R.drawable.curse_ceremony_lunge;
            case "平板撐體":
                return R.drawable.flat_support;
            case "引體向上":
                return R.drawable.pull_up;
            case "捲腹":
                return R.drawable.crimping;
            case "深蹲":
                return R.drawable.squat;
            case "爬山式":
                return R.drawable.mountaineering;
            case "臥姿抬臀":
                return R.drawable.supine_hip_lift;
            case "啞鈴練習":
                return R.drawable.lifting_dumbbells;
            default:
                return R.drawable.lifting_dumbbells;
        }
    }
}
