package com.recruit.paythem.repository;


//@Repository
//public class RecruitmentRepositoryImpl implements RecruitmentRepository{
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//	@Override
//	public List<Map<String, Object>> findRecruitmnetByHeadHunterIdAndGroupAndRecruitmentDate(int headHunterId,
//			String group, int month) {
//		
//	String	 sql = "SELECT r.ID AS RECRUITMENT_ID,c.TYPE,r.GROUP ,r.RECRUITMENT_DATE \r\n" + 
//			"FROM RECRUITMENT r \r\n" + 
//			"INNER JOIN HEAD_HUNTER h \r\n" + 
//			"ON r.HEAD_HUNTER_ID=h.ID\r\n" + 
//			"INNER JOIN CATAGORY c\r\n" + 
//			"ON r.CATAGORY_ID=c.ID \r\n" + 
//			"WHERE h.ID=:headHunterId AND r.GROUP=:group AND MONTH(r.RECRUITMENT_DATE)=:month";
//
//        Map map = new HashMap();
//         map.put("headHunterId", headHunterId);
//         map.put("group", group);
//         map.put("month", month);
//         List<Map<String, Object>> list=namedParameterJdbcTemplate.queryForList(sql, map);
//	        return list;
//	}
//
//}
