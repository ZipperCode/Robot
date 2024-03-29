package org.chat.utils.nlpir;

/**
 * 分词组件方法类
 * 
 * @author zzp
 *
 */

public class Nlpir {

    private boolean initState = false;

    public Nlpir(){
		init("");
	}

	public Nlpir(String dataPath){
    	init(dataPath);
	}

	public boolean initState(){
    	return initState;
	}

	/**
	 * 组件初始化
	 * 
	 * @param sDataPath Data文件夹的父目录，如果为空字符串（即：""），那么，程序自动从项目的根目录中寻找
	 * @return true：初始化成功；false：初始化失败
	 */
	public  boolean init(String sDataPath){
        initState = NlpirLib.Instance.NLPIR_Init(sDataPath, 1, "");
        if (initState) {
            System.out.println("nlpir初始化成功");
        } else {
            System.out.println("nlpir初始化失败：" + NlpirLib.Instance.NLPIR_GetLastErrorMsg());
        }
        return initState;
    }

	/**
	 * 分词
	 * 
	 * @param sParagraph 文本内容
	 * @param bPOSTagged 1：显示词性；0：不显示词性
	 * @return 分词结果
	 */
	public String paragraphProcess(String sParagraph, int bPOSTagged) {
		return initState ? NlpirLib.Instance.NLPIR_ParagraphProcess(sParagraph, bPOSTagged) : null;
	}

	/**
	 * 分词
	 * 
	 * @param sSourceFilename 文本文件的路径
	 * @param sResultFilename 结果文件的路径
	 * @param bPOStagged 1：显示词性；0：不显示词性
	 * @return
	 */
	public double fileProcess(String sSourceFilename, String sResultFilename, int bPOStagged) {
		return initState ? NlpirLib.Instance.NLPIR_FileProcess(sSourceFilename, sResultFilename, bPOStagged) : 0;
	}

	/**
	 * 细粒度分词
	 * 
	 * @param lenWords 文本内容
	 * @return 分词结果
	 */
	public String finerSegment(String lenWords) {
		return initState ? NlpirLib.Instance.NLPIR_FinerSegment(lenWords) : null;
	}

	/**
	 * 关键词
	 * 
	 * @param sLine 文本内容
	 * @param nMaxKeyLimit 生成关键词的个数上限
	 * @param bWeightOut true：显示词性；false：不显示词性
	 * @return 关键词组成的字符串 备注：黑名单中出现的词，不会作为关键词出现
	 */
	public String getKeyWords(String sLine, int nMaxKeyLimit, boolean bWeightOut) {
		return initState ? NlpirLib.Instance.NLPIR_GetKeyWords(sLine, nMaxKeyLimit, bWeightOut) : null;
	}

	/**
	 * 关键词
	 * 
	 * @param sFilename 文本文件的路径
	 * @param nMaxKeyLimit 生成的关键词的个数上限
	 * @param bWeightOut true：显示词性；false：不显示词性
	 * @return 关键词组成的字符串 备注：黑名单中出现的词，不会作为关键词出现
	 */
	public String getFileKeyWords(String sFilename, int nMaxKeyLimit, boolean bWeightOut) {
		return initState ?
				NlpirLib.Instance.NLPIR_GetFileKeyWords(sFilename, nMaxKeyLimit, bWeightOut)
				: null;
	}

	/**
	 * 新词
	 * 
	 * @param sLine 文本内容
	 * @param nMaxKeyLimit 生成的新词的个数上限
	 * @param bWeightOut true：显示词性；false：不显示词性
	 * @return 新词组成的字符串
	 */
	public String getNewWords(String sLine, int nMaxKeyLimit, boolean bWeightOut) {
		return initState ? NlpirLib.Instance.NLPIR_GetNewWords(sLine, nMaxKeyLimit, bWeightOut) : null;
	}

	/**
	 * 新词
	 * 
	 * @param sFilename 文本文件的路径
	 * @param nMaxKeyLimit 生成的新词的个数上限
	 * @param bWeightOut true:显示词性信息；false:不显示词性信息
	 * @return 新词组成的字符串
	 */
	public String getFileNewWords(String sFilename, int nMaxKeyLimit, boolean bWeightOut) {
		return initState ? NlpirLib.Instance.NLPIR_GetFileNewWords(sFilename, nMaxKeyLimit, bWeightOut) : null;
	}

	/**
	 * 添加用户自定义词
	 * 
	 * @param userWord 用户词 格式：单词+空格+词性，例如：你好 v
	 * @return 1：内存中不存在；2：内存中已存在 备注：保存到内存中，下次初始化后失效，需要用save保存到文件中
	 */
	public int addUserWord(String userWord) {
		return initState ? NlpirLib.Instance.NLPIR_AddUserWord(userWord) : 0;
	}

	/**
	 * 保存用户自定义词(保存到文件中)
	 * 
	 * @return 1：成功；0：失败
	 */
	public int saveTheUsrDic() {
		return initState ? NlpirLib.Instance.NLPIR_SaveTheUsrDic() : 0;
	}

	/**
	 * 删除用户自定义词
	 * 
	 * @param sWord 需要删除的单词
	 * @return 被删除单词在内存中的位置，-1表示不存在 备注：删除内存中的自定义词，下次初始化后失效，需要用save保存到文件中
	 */
	public int delUsrWord(String sWord) {
		return initState ? NlpirLib.Instance.NLPIR_DelUsrWord(sWord) : 0;
	}

	/**
	 * 导入用户自定义词典
	 * 
	 * @param dictFileName 用户词典的路径
	 * @param bOverwrite 是否删除原有的自定义用户词典，true：删除；false：不删除
	 * @return 导入用户单词个数 备注：系统会自动处理重复词的问题
	 */
	public int importUserDict(String dictFileName, boolean bOverwrite) {
		return initState ? NlpirLib.Instance.NLPIR_ImportUserDict(dictFileName, bOverwrite) : 0;
	}

	/**
	 * 导入关键词黑名单
	 * 
	 * @param sFilename 文件的路径
	 * @return 备注：成功导入后，黑名单中出现的词，不会作为关键词出现
	 */
	public int importKeyBlackList(String sFilename) {
		return initState ? NlpirLib.Instance.NLPIR_ImportKeyBlackList(sFilename) : 0;
	}

	/**
	 * 文章指纹码
	 * 
	 * @param sLine 文本内容
	 * @return 指纹码
	 */
	public long fingerPrint(String sLine) {
		return initState ? NlpirLib.Instance.NLPIR_FingerPrint(sLine) : 0;
	}

	/**
	 * 单词的词性
	 * 
	 * @param sWords 单词，例如：中华人民共和国
	 * @return 单词的词性，例如：中华人民共和国/ns/607#
	 */
	public String getWordPOS(String sWords) {
		return initState ? NlpirLib.Instance.NLPIR_GetWordPOS(sWords) : null;
	}

	/**
	 * 判断单词是否在核心词库中
	 * 
	 * @param word 输入的单词
	 * @return 如果单词不存在就返回-1，否则返回单词在词典中的句柄
	 */
	public int isWord(String word) {
		return initState ? NlpirLib.Instance.NLPIR_IsWord(word) : 0;
	}

	/**
	 * 获取输入文本的词，词性，频统计结果，按照词频大小排序
	 * 
	 * @param sText 文本内容
	 * @return 词频统计结果形式如下：张华平/nr/10#博士/n/9#分词/n/8
	 */
	public String wordFreqStat(String sText) {
		return initState ? NlpirLib.Instance.NLPIR_WordFreqStat(sText) : null;
	}

	/**
	 * 获取输入文本文件的词，词性，频统计结果，按照词频大小排序
	 * 
	 * @param sFilename 文本文件的全路径
	 * @return 词频统计结果形式如下：张华平/nr/10#博士/n/9#分词/n/8
	 */
	public String fileWordFreqStat(String sFilename) {
		return initState ? NlpirLib.Instance.NLPIR_FileWordFreqStat(sFilename) : null;
	}

	/**
	 * 获取各类英文单词的原型，考虑了过去分词、单复数等情况
	 * 
	 * @param sWord 输入的单词
	 * @return 词原型形式，例如：driven->drive drives->drive drove-->drive
	 */
	public String getEngWordOrign(String sWord) {
		return initState ? NlpirLib.Instance.NLPIR_GetEngWordOrign(sWord) : null;
	}

	/**
	 * 返回最后一次的出错信息
	 * 
	 * @return 最后一次的出错信息
	 */
	public String getLastErrorMsg() {
		return initState ? NlpirLib.Instance.NLPIR_GetLastErrorMsg() : null;
	}

	/**
	 * 退出，释放资源
	 * 
	 * @return
	 */
	public boolean exit() {
		return NlpirLib.Instance.NLPIR_Exit();
	}
}
