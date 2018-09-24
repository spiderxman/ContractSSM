package com.masago.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;


/**
 * 共通クラス
 * @version 1.0
 */
public class PropertyUtil {
	//Loggerインスタンス
	private static CmnLogger logger = new CmnLogger();
	// 外部ファイル名
	public static final String PROP_FILENAME ="messages.properties";
	// プロパティ情報
	private Properties properties = null;

	/**
	 * リソース内プロパティファイルの読み込み
	 * @throws IOException 読み込み例外
	 */
	public void readProperties() throws IOException{
    	logger.debug("readProperties start");
		logger.debug("read propertyfile : "+PROP_FILENAME);
		// プロパティファイルのstream取得
		InputStream is
			= Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(PROP_FILENAME);
		//プロパティファイルの読み込み
		readproperties(is);
    	logger.debug("readProperties end");
	}

	/**
	 * プロパティファイルの読み込み
	 * @param is 読み込み用ストリーム
	 * @throws IOException  読み込み例外
	 */
	public void readproperties(InputStream is) throws IOException{
		// エラーチェック
		if(is==null){
			return;
		}
		//
		if(properties==null){
			//プロパティファイルインスタンス生成
			properties = new Properties();
		}
		//プロパティファイルロード
		properties.load(new InputStreamReader(is,"UTF-8"));
	}

	/**
	 * プロパティ値の設定
	 * @param key プロパティ名
	 * @param value プロパティ値
	 */
	public void setProp(String key,String value){
		logger.debug("setProp　start");
		logger.debug("--------- param -----------");
		logger.debug("key = "+key);
		logger.debug("value = "+value);
		logger.debug("--------- end -----------");

		if(properties==null){
			//プロパティファイルのインスタンス生成
			properties = new Properties();
		}
		//プロパティ値の設定
		properties.setProperty(key, value);
		logger.debug("setProp end");
	}

	/**
	 * プロパティの取得
	 * @param key プロパティ名
	 * @return プロパティ値
	 */
	private String getProp(String key){
		logger.debug("getProp start");
		logger.debug("--------- param -----------");
		logger.debug("key = "+key);
		logger.debug("--------- end -----------");
		if(properties!=null){
			//プロパティ値の取得
			logger.debug("getProp end");
			return properties.getProperty(key, "");
		}
		logger.debug("getProp end");
		return "";
	}

	/**
	 * プロパティ値の取得　（置き換え文字なし）
	 * @param key プロパティ名
	 * @return プロパティ値
	 */
	public String getProperty(String key){
		return getProp(key);
	}

	/**
	 * プロパティの取得　（置き換え文字あり）
	 * @param key プロパティ名
	 * @param sub 置き換え文字の配列　(最大5個まで。5個以上の場合、空白を返却）
	 * @return 置き換え後プロパティ値
	 */
	public String getProperty(String key, String[] sub) {
		logger.debug("getProperty start");
		logger.debug("--------- param -----------");
		logger.debug("key = "+key);
		for(int cnt=0; cnt<sub.length; cnt++){
			logger.debug("sub["+cnt+"] = "+sub[cnt]);
		}
		logger.debug("--------- end -----------");
		String retMsg = "";
		String msg = getProp(key);
		if(sub.length == 1){
			retMsg = MessageFormat.format(msg,sub[0]);
		}else if(sub.length == 2){
			retMsg = MessageFormat.format(msg,sub[0],sub[1]);
		}else if(sub.length == 3){
			retMsg = MessageFormat.format(msg,sub[0],sub[1],sub[2]);
		}else if(sub.length == 4){
			retMsg = MessageFormat.format(msg,sub[0],sub[1],sub[2],sub[3]);
		}else if(sub.length == 5){
			retMsg = MessageFormat.format(msg,sub[0],sub[1],sub[2],sub[3],sub[4]);
		}else{
			retMsg = "";
		}
		logger.debug("getProperty end");
		return retMsg;
	}
}
