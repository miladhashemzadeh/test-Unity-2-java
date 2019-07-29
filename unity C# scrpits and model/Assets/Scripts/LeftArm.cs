using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LeftArm : MonoBehaviour {

	float x=30.0f,y=30.0f,z=30.0f;

	// Use this for initialization
	void Start () {
		AndroidJavaClass UnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer"); 
		AndroidJavaObject currentActivity = UnityPlayer.GetStatic<AndroidJavaObject>	("currentActivity");

		AndroidJavaObject intent = currentActivity.Call<AndroidJavaObject>("getIntent");
		bool hasExtra = intent.Call<bool> ("hasExtra", "leftaxies");

		if (hasExtra) {
			AndroidJavaObject extras = intent.Call<AndroidJavaObject> ("getExtras");
			string axies = extras.Call<string> ("getString", "leftaxies");
			string[] axiesArr = axies.Split (',');
			x = System.Convert.ToSingle(axiesArr[0]);
			y = System.Convert.ToSingle(axiesArr[1]);
			z = System.Convert.ToSingle(axiesArr[2]);
		}
	}

	// Update is called once per frame
	void Update () {
		transform.Rotate(Time.smoothDeltaTime * x,Time.smoothDeltaTime * y,Time.smoothDeltaTime * z);
	}

}
