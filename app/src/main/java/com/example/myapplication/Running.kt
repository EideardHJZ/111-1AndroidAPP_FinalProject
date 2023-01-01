package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class Running : AppCompatActivity() {
    var status_ch = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running)
        val tx_show = findViewById<TextView>(R.id.textView)
        val ed_gt = findViewById<EditText>(R.id.editTextTextPersonName)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val tx_time = findViewById<TextView>(R.id.tx_time)


        val countDownTimer:CountDownTimer
        var countDT: Long = 111000
        var countIl: Long = 1000

        var substr = ""

        val btch = intent.getStringExtra("btCH")


////////////要顯示的文章
        val sh1 = "山不在高，有仙則名。水不在深，有龍則靈。斯是陋室，惟吾德馨。苔痕上階綠，草色入簾青。談笑有鴻儒，往來無白丁。可以調素琴，閱金經。無絲竹之亂耳，無案牘之勞形。南陽諸葛廬，西蜀子云亭。孔子云：何陋之有？----劉禹錫"
        val sh2 = "聲音是通過物體振動產生的聲波。通過介質（空氣或固體、液體）傳播並能被人或動物聽覺器官所感知的波動現象。人類耳朵能聽到聲音範圍是20Hz~20kHz（可聽聲波 Acoustic）。對於低於20Hz（次聲波 Infrasound）或高於20kHz（超聲波 Ultrasound）的聲音都是聽不到的。在音樂中，聲音分為樂音和噪音。一般樂音是有規則振動的聲音有高低之分，構成音樂主體，噪音是無規則振動的聲音，無明顯的固定音高。藉著示波器觀察，若波形規則地反覆，則為樂音；若波形為不規則的音，則為噪音。"
        val sh3 = "小美的朋友就要去當兵了，大夥為他送行去吃飯聊天，其中有個當過兵的人說；很多人剛去當兵3天大不出來，他自己也是。哇！那肚子會不會變很大嗎？這是真的嗎？那不就要帶通便藥去了？"
        val sh4 = "般若波羅蜜多心經---觀自在菩薩。行深般若波羅蜜多時。照見五蘊皆空。度一切苦厄。舍利子。色不異空。空不異色。色即是空。空即是色。受想行識。亦復如是。舍利子。是諸法空相。不生不滅。不垢不淨。不增不減。是故空中無色。無受想行識。無眼耳鼻舌身意。無色聲香味觸法。無眼界。乃至無意識界。無無明。亦無無明盡。乃至無老死。亦無老死盡。無苦集滅道。無智亦無得。以無所得故。菩提薩埵。依般若波羅蜜多故。心無罣礙。無罣礙故。無有恐怖。遠離顛倒夢想。究竟涅槃。三世諸佛。依般若波羅蜜多故。得阿耨多羅三藐三菩提。故知般若波羅蜜多。是大神咒。是大明咒。是無上咒。是無等等咒。能除一切苦。真實不虛。故說般若波羅蜜多咒。即說咒曰。揭諦揭諦。波羅揭諦。波羅僧揭諦。菩提薩婆訶。"
        val sh5 = "有位帥哥開著一輛敞篷的賓士，一手握著方向盤還一手拿沙士，又飛過一輛閃閃發亮的BMW，我卻站在人行道上飲豆奶，每個人的心中都有一輛夢幻車，不要跟我說她只是代步的工具，引擎發動之後就要人車一體，趕快踩下油門帶我貼地飛行，轟隆隆隆隆隆隆衝衝衝衝，拉風，引擎發動，引擎發動。一瞬間踩下油門催乎盡磅，乘風！衝！衝！讓窗外的風，吹動每一個毛孔，我是今夜，最稀有的品種。讓看到的人以為是夢，還沒醒來就已經無影無蹤。風敲醒每一個面孔，我是明天被讚嘆的驚悚。讓看到的人全部感動，零到一百K，only四秒鐘。紅燈停！綠燈行！看到行人要當心！快車道！慢車道！平安回家才是王道！開車不是騎車不怕沒戴安全帽，只怕警察逼逼逼！叫我路邊靠：BIBIBIBIBI！大燈忘了開！BIBIBIBIBI！駕照沒有帶！BIBIBIBIBI！偷偷講電話！BIBIBIBIBI！沒繫安全帶！我的夢幻車子就是最辣的美女 ！有她陪伴哪怕車上只有收音機！我就像隻野狼身上披著羊的皮！我的心情好比開著一架戰鬥機！"
        val sh6 = "因應中國大陸疫情升溫，自明年1月1日零時起，自中國大陸來台旅客機場採唾液PCR，並配合7天自主防疫及自我篩檢。指揮中心指出，隨中國大陸近期調整COVID-19疫情防控措施，加上其疫情資訊不明、感染者有激增情形，目前已有日本、義大利等國家紛紛祭出相應邊境管控措施，加強對中國大陸入境旅客全面採檢、管控航班或其他嚴格措施，預期中國大陸疫情亦可能衝擊我國防疫及醫療量能。指揮中心強調，所有入境旅客抵台時領取快篩試劑後，請落實7天自主防疫規定，於入境當天或自主防疫第1天，以及有症狀時進行自我快篩，以維護自身及國人健康；自主防疫期間外出時，需持有2日內快篩陰性結果。篩檢陽性者依規定進行5+n居家照護及自主健康管理。"
        val sh7 = "千手千眼觀世音菩薩廣大圓滿無礙大悲心陀羅尼經---南無喝囉怛那哆囉夜耶。南無阿唎耶。婆盧羯帝爍缽囉耶。菩提薩埵婆耶。摩訶薩埵婆耶。摩訶迦盧尼迦耶。唵。薩皤囉罰曳。數怛那怛寫。南無悉吉利埵伊蒙阿唎耶。婆盧吉帝室佛囉楞馱婆。南無那囉謹墀。醯唎摩訶皤哆沙咩。薩婆阿他豆輸朋。阿逝孕。薩婆薩哆那摩婆。薩多那摩婆伽。摩罰特豆。怛侄他。唵。阿婆盧醯。盧迦帝。迦羅帝。夷醯唎。摩訶菩提薩埵。薩婆薩婆。摩囉摩囉。摩醯摩醯唎馱孕。俱盧俱盧羯蒙。度盧度盧罰闍耶帝。摩訶罰闍耶帝。陀囉陀囉。地唎尼。室佛囉耶。遮囉遮囉。麼麼罰摩囉。穆帝隸。伊醯伊醯。室那室那。阿囉嘇佛囉舍利。罰娑罰嘇。佛囉舍耶。呼盧呼盧摩囉。呼盧呼盧醯利。娑囉娑囉。悉唎悉唎。蘇嚧蘇嚧。菩提夜·菩提夜。菩馱夜·菩馱夜。彌帝利夜。那囉謹墀。地利瑟尼那。婆夜摩那。娑婆訶。悉陀夜。娑婆訶。摩訶悉陀夜。娑婆訶。悉陀喻藝。室皤囉夜。娑婆訶。那囉謹墀。娑婆訶。摩囉那囉。娑婆訶。悉囉僧·阿穆佉耶。娑婆訶。娑婆摩訶·阿悉陀夜。娑婆訶。者吉囉·阿悉陀夜。娑婆訶。波陀摩·羯悉陀夜。娑婆訶。那囉謹墀·皤伽囉耶。娑婆訶。摩婆利·勝羯囉夜。娑婆訶。南無喝囉怛那·哆囉夜耶。南無阿利耶。婆嚧吉帝。爍皤囉夜。娑婆訶。唵·悉殿都。漫多囉。跋陀耶。娑婆訶。"
        val sh8 = "塞納河畔左岸的咖啡，我手一杯品嚐你的美，留下唇印的嘴。花店玫瑰名字寫錯誰，告白氣球風吹到對街，微笑在天上飛。你說你有點難追，想讓我知難而退，禮物不需挑最貴，只要香榭的落葉，營造浪漫的約會，不害怕搞砸一切，擁有你就擁有，全世界。親愛的，愛上你，從那天起，甜蜜的很輕易；親愛的，別任性，你的眼睛，在說我願意。塞納河畔左岸的咖啡，我手一杯品嚐你的美，留下唇印的嘴。花店玫瑰名字寫錯誰，告白氣球風吹到對街，微笑在天上飛。你說你有點難追，想讓我知難而退，禮物不需挑最貴，只要香榭的落葉，營造浪漫的約會，不害怕搞砸一切，擁有你就擁有，全世界。親愛的，愛上你，從那天起，甜蜜的很輕易；親愛的，別任性，你的眼睛，在說我願意。親愛的，愛上你，戀愛日記，飄香水的回憶。一整瓶，的夢境，全都有你，攪拌在一起。親愛的，別任性，你的眼睛！在說我願意！"
        val sh9 = "俗話說的好，掌握思考過程，也就掌握了發燒時事。回過神才發現，思考發燒時事的存在意義，已讓我廢寢忘食。拉布呂耶爾說過一句發人省思的話，位居我們之上的人們，只要露出一絲拒絕或冷淡的神色，就會招致我們的仇恨; 但只需一聲問候或一個微笑，又會立刻化我們心頭的冰霜。這讓我的思緒清晰了。契訶夫在過去曾經講過，人應當一切都美，外貌、衣著、靈魂、思想。這段話的餘韻不斷在我腦海中迴盪著。世界上若沒有發燒時事，對於人類的改變可想而知。"
//



        if(status_ch == true){
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        else{

            if(btch == "1"){
                substr = sh1
                tx_show.text = sh1}
            else if(btch == "2"){
                substr = sh2
                tx_show.text = sh2}
            else if(btch == "3"){
                substr = sh3
                tx_show.text = sh3}
            else if(btch == "4"){
                substr = sh4
                tx_show.text = sh4}
            else if(btch == "5"){
                substr = sh5
                tx_show.text = sh5}
            else if(btch == "6"){
                substr = sh6
                tx_show.text = sh6}
            else if(btch == "7"){
                substr = sh7
                tx_show.text = sh7}
            else if(btch == "8"){
                substr = sh8
                tx_show.text = sh8}
            else{
                substr = sh9
                tx_show.text = sh9}




            countDownTimer = object : CountDownTimer(countDT,countIl){
                override fun onTick(p0: Long) {
                    tx_time.text = (p0/1000).toString()


                }

                override fun onFinish() {
                    tx_time.text = ""
                    status_ch = true
                    resetPr(substr)

                }
            }
            countDownTimer.start()

            btn_send.setOnClickListener({

                countDownTimer.cancel()
                status_ch = true
                resetPr(substr)
            })
        }




    }


    private fun resetPr(str:String){
        val ed_gt = findViewById<EditText>(R.id.editTextTextPersonName)
        val tx_show = findViewById<TextView>(R.id.textView)
        val tx_time = findViewById<TextView>(R.id.tx_time)
        val intent = Intent(this, Result::class.java)
        val intext = ed_gt.text.toString()
        intent.putExtra("content",intext)
        intent.putExtra("articalTXT",str)
        ed_gt.text.clear()
        tx_show.text = ""
        tx_time.text = ""



        startActivity(intent)
    }


}