package json;

import com.alibaba.fastjson.JSONObject;
import didiSDK.DistanceUtil;
import didiSDK.entity.DidiDrivingRoad;
import didiSDK.entity.DidiOrderBillInfo;
import didiSDK.entity.DidiOrderDetailInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author gongzhao
 * @description
 * @Date 14:032019/1/7
 */
@Slf4j
public class JsonParse {

    public static void main(String[] args) throws Exception {
        DidiOrderDetailInfo detailInfo = JSONObject.parseObject(orderDetailData, DidiOrderDetailInfo.class);
        List<DidiDrivingRoad> didiDrivingRoads = detailInfo.getDrivingRoads();
        if (didiDrivingRoads.size() > 0) {
            for (DidiDrivingRoad drivingRoad : didiDrivingRoads) {
                drivingRoad.setLocation(DistanceUtil.addressParse(String.valueOf(drivingRoad.getLat()), String.valueOf(drivingRoad.getLng())));
            }
        }
        log.info("订单详情信息:{}", detailInfo.toString());
        DidiOrderBillInfo billInfo = JSONObject.parseObject(orderBillData, DidiOrderBillInfo.class);
        log.info("账单详情信息:{}", billInfo);
    }


    static String orderBillData = "{\n" +
            "\t\"channelItems\": [{\n" +
            "\t\t\"des\": \"微信支付\",\n" +
            "\t\t\"downGradleType\": 0,\n" +
            "\t\t\"type\": 2\n" +
            "\t}, {\n" +
            "\t\t\"des\": \"支付宝\",\n" +
            "\t\t\"downGradleType\": 0,\n" +
            "\t\t\"type\": 1\n" +
            "\t}],\n" +
            "\t\"memo\": \"费用按开始行驶时间计算,本单10:10开始行驶\",\n" +
            "\t\"enterprisePay\": false,\n" +
            "\t\"voucherAmount\": 0.0,\n" +
            "\t\"rewardRule\": 0,\n" +
            "\t\"platformPaid\": 0.0,\n" +
            "\t\"discountType\": 1,\n" +
            "\t\"shouldPayFee\": 55.0,\n" +
            "\t\"ePayType\": 1,\n" +
            "\t\"selectChannelType\": 0,\n" +
            "\t\"mileage\": 6076,\n" +
            "\t\"reward\": 0.0,\n" +
            "\t\"showMileageDetail\": 0,\n" +
            "\t\"isNew\": true,\n" +
            "\t\"riskType\": 1,\n" +
            "\t\"etime\": 1546829208000,\n" +
            "\t\"notNeedPay\": false,\n" +
            "\t\"feeItems\": [{\n" +
            "\t\t\"detail\": \"(含6.08公里)\",\n" +
            "\t\t\"money\": 55.0,\n" +
            "\t\t\"label\": \"起步价\",\n" +
            "\t\t\"type\": 3\n" +
            "\t}, {\n" +
            "\t\t\"detail\": \"(1分钟)\",\n" +
            "\t\t\"money\": 0.0,\n" +
            "\t\t\"label\": \"等候费\",\n" +
            "\t\t\"type\": 2\n" +
            "\t}, {\n" +
            "\t\t\"detail\": \"(不支持代金券抵扣)\",\n" +
            "\t\t\"money\": 0.0,\n" +
            "\t\t\"label\": \"其他费用\",\n" +
            "\t\t\"type\": 8\n" +
            "\t}],\n" +
            "\t\"totalMoney\": 55.0,\n" +
            "\t\"voucherId\": 0,\n" +
            "\t\"driveTime\": 2192\n" +
            "}";


    static String orderDetailData = "{\n" +
            "\t\"suspend\": 0,\n" +
            "\t\"endLng\": 123.4574148220486,\n" +
            "\t\"startPoiName\": \"人人车维修保养中心(惠修行店)\",\n" +
            "\t\"isRelayOrder\": false,\n" +
            "\t\"producerMob\": \"13066640337\",\n" +
            "\t\"type\": 0,\n" +
            "\t\"bizCollect\": 0,\n" +
            "\t\"pName\": \"\",\n" +
            "\t\"mile\": 8,\n" +
            "\t\"subBizType\": 0,\n" +
            "\t\"startPoiAddress\": \"人人车维修保养中心(惠修行店)\",\n" +
            "\t\"orderState\": 8,\n" +
            "\t\"endPoiName\": \"辽宁文学院电大教学部\",\n" +
            "\t\"enterprisePayType\": 1,\n" +
            "\t\"contactMob\": \"13066640337\",\n" +
            "\t\"totalFee\": 50.0,\n" +
            "\t\"pbTimeStr\": \"12月19日 17:32\",\n" +
            "\t\"pMob\": \"13066640337\",\n" +
            "\t\"isShowDuty\": 1,\n" +
            "\t\"bizType\": 7,\n" +
            "\t\"endChargeTime\": 1545213198000,\n" +
            "\t\"payType\": 1,\n" +
            "\t\"halfwait\": 0,\n" +
            "\t\"isLimitAction\": 1,\n" +
            "\t\"chargetype\": 0,\n" +
            "\t\"isBegin\": true,\n" +
            "\t\"helpPayChannel\": 0,\n" +
            "\t\"isShortOrder\": 0,\n" +
            "\t\"waitTime\": 4,\n" +
            "\t\"helpFlag\": 0,\n" +
            "\t\"isRemoteFee3\": false,\n" +
            "\t\"payState\": 2,\n" +
            "\t\"drivingRoads\": [{\n" +
            "\t\t\"stime\": 1545212169342,\n" +
            "\t\t\"lng\": 123.389,\n" +
            "\t\t\"lat\": 41.84281\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212189286,\n" +
            "\t\t\"lng\": 123.389,\n" +
            "\t\t\"lat\": 41.84321\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212209316,\n" +
            "\t\t\"lng\": 123.38894,\n" +
            "\t\t\"lat\": 41.8452\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212229325,\n" +
            "\t\t\"lng\": 123.38795,\n" +
            "\t\t\"lat\": 41.84727\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212249419,\n" +
            "\t\t\"lng\": 123.3868,\n" +
            "\t\t\"lat\": 41.84896\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212269376,\n" +
            "\t\t\"lng\": 123.38662,\n" +
            "\t\t\"lat\": 41.84923\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212289395,\n" +
            "\t\t\"lng\": 123.38556,\n" +
            "\t\t\"lat\": 41.85083\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212309415,\n" +
            "\t\t\"lng\": 123.38465,\n" +
            "\t\t\"lat\": 41.85219\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212329448,\n" +
            "\t\t\"lng\": 123.38373,\n" +
            "\t\t\"lat\": 41.85354\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212349478,\n" +
            "\t\t\"lng\": 123.38357,\n" +
            "\t\t\"lat\": 41.85396\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212399589,\n" +
            "\t\t\"lng\": 123.38448,\n" +
            "\t\t\"lat\": 41.85524\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212419523,\n" +
            "\t\t\"lng\": 123.38443,\n" +
            "\t\t\"lat\": 41.85645\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212439570,\n" +
            "\t\t\"lng\": 123.38445,\n" +
            "\t\t\"lat\": 41.85881\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212469701,\n" +
            "\t\t\"lng\": 123.38815,\n" +
            "\t\t\"lat\": 41.85892\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212489719,\n" +
            "\t\t\"lng\": 123.3905,\n" +
            "\t\t\"lat\": 41.85901\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212509639,\n" +
            "\t\t\"lng\": 123.39413,\n" +
            "\t\t\"lat\": 41.85912\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212529682,\n" +
            "\t\t\"lng\": 123.39843,\n" +
            "\t\t\"lat\": 41.85926\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212549684,\n" +
            "\t\t\"lng\": 123.40309,\n" +
            "\t\t\"lat\": 41.85945\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212569817,\n" +
            "\t\t\"lng\": 123.40817,\n" +
            "\t\t\"lat\": 41.85969\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212589824,\n" +
            "\t\t\"lng\": 123.41203,\n" +
            "\t\t\"lat\": 41.85978\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212609824,\n" +
            "\t\t\"lng\": 123.41594,\n" +
            "\t\t\"lat\": 41.86005\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212629864,\n" +
            "\t\t\"lng\": 123.41947,\n" +
            "\t\t\"lat\": 41.86076\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212649914,\n" +
            "\t\t\"lng\": 123.42255,\n" +
            "\t\t\"lat\": 41.86166\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212669834,\n" +
            "\t\t\"lng\": 123.4269,\n" +
            "\t\t\"lat\": 41.86243\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212689930,\n" +
            "\t\t\"lng\": 123.43051,\n" +
            "\t\t\"lat\": 41.86298\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212709955,\n" +
            "\t\t\"lng\": 123.43309,\n" +
            "\t\t\"lat\": 41.8631\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212730003,\n" +
            "\t\t\"lng\": 123.43504,\n" +
            "\t\t\"lat\": 41.86101\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212749938,\n" +
            "\t\t\"lng\": 123.43607,\n" +
            "\t\t\"lat\": 41.8578\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212769959,\n" +
            "\t\t\"lng\": 123.4371,\n" +
            "\t\t\"lat\": 41.85452\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212790061,\n" +
            "\t\t\"lng\": 123.4379,\n" +
            "\t\t\"lat\": 41.85199\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212880078,\n" +
            "\t\t\"lng\": 123.43763,\n" +
            "\t\t\"lat\": 41.8529\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212900098,\n" +
            "\t\t\"lng\": 123.4413,\n" +
            "\t\t\"lat\": 41.85122\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212920211,\n" +
            "\t\t\"lng\": 123.44634,\n" +
            "\t\t\"lat\": 41.85143\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212940160,\n" +
            "\t\t\"lng\": 123.44709,\n" +
            "\t\t\"lat\": 41.85145\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545212990203,\n" +
            "\t\t\"lng\": 123.45424,\n" +
            "\t\t\"lat\": 41.85181\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545213010242,\n" +
            "\t\t\"lng\": 123.45695,\n" +
            "\t\t\"lat\": 41.85193\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545213030287,\n" +
            "\t\t\"lng\": 123.45693,\n" +
            "\t\t\"lat\": 41.84964\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545213050349,\n" +
            "\t\t\"lng\": 123.45692,\n" +
            "\t\t\"lat\": 41.84833\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545213080381,\n" +
            "\t\t\"lng\": 123.4569,\n" +
            "\t\t\"lat\": 41.84768\n" +
            "\t}, {\n" +
            "\t\t\"stime\": 1545213100335,\n" +
            "\t\t\"lng\": 123.45691,\n" +
            "\t\t\"lat\": 41.84773\n" +
            "\t}],\n" +
            "\t\"isPassMistaken\": 0,\n" +
            "\t\"startChargeTime\": 1545212097000,\n" +
            "\t\"h5PublishRemoteFee3\": false,\n" +
            "\t\"endLat\": 41.8477099609375,\n" +
            "\t\"pbTime\": 1545211961000,\n" +
            "\t\"endPoiAddress\": \"辽宁省沈阳市皇姑区鸭绿江街53号(天菱家园西)\",\n" +
            "\t\"relayOrderSuccess\": false,\n" +
            "\t\"startLng\": 123.388771,\n" +
            "\t\"star\": 5,\n" +
            "\t\"back\": 0,\n" +
            "\t\"pid\": 162220831,\n" +
            "\t\"driverInfo\": {\n" +
            "\t\t\"phoneCallingForbidden\": 1,\n" +
            "\t\t\"mob\": \"18540306808\",\n" +
            "\t\t\"levelDesc\": \"钻石司机\",\n" +
            "\t\t\"driveingAge\": 12,\n" +
            "\t\t\"did\": 2832342260406150,\n" +
            "\t\t\"starLever\": 5.0,\n" +
            "\t\t\"headThumbUrl\": \"http://img.kuaidadi.com/certificate/clip_2832342260406150_1528705706352_6H8jf.jpg\",\n" +
            "\t\t\"driverName\": \"张师傅\",\n" +
            "\t\t\"jobNum\": \"965437\",\n" +
            "\t\t\"drivingCount\": 1311\n" +
            "\t},\n" +
            "\t\"begin\": true,\n" +
            "\t\"endTimeStr\": \"\",\n" +
            "\t\"startTimeStr\": \"\",\n" +
            "\t\"groupId\": 0,\n" +
            "\t\"paiedFee\": 50.0,\n" +
            "\t\"payer\": 0,\n" +
            "\t\"startLat\": 41.842781,\n" +
            "\t\"otherUnfinishOrder\": 0,\n" +
            "\t\"channel\": 5,\n" +
            "\t\"voucherIdStr\": \"\"\n" +
            "}";
}
