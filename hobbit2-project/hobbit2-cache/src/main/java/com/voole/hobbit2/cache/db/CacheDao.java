/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.voole.hobbit2.cache.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.voole.hobbit2.cache.AreaInfoCache.AreaInfosFetch;
import com.voole.hobbit2.cache.MovieInfoCache.MovieInfoFetch;
import com.voole.hobbit2.cache.OemInfoCache.OemInfoFetch;
import com.voole.hobbit2.cache.ParentAreaInfoCache.ParentAreaInfoFetch;
import com.voole.hobbit2.cache.ParentSectionInfoCache.ParentSectionInfoFetch;
import com.voole.hobbit2.cache.ProductInfoCache.ProductInfoFetch;
import com.voole.hobbit2.cache.ResourceInfoCache.ResourceInfoFetch;
import com.voole.hobbit2.cache.SpInfoCache.SpInfosFetch;
import com.voole.hobbit2.cache.entity.AreaInfo;
import com.voole.hobbit2.cache.entity.BoxStoreAreaInfo;
import com.voole.hobbit2.cache.entity.DeviceInfo;
import com.voole.hobbit2.cache.entity.EpgInfo;
import com.voole.hobbit2.cache.entity.MovieInfo;
import com.voole.hobbit2.cache.entity.OemInfo;
import com.voole.hobbit2.cache.entity.ParentAreaInfo;
import com.voole.hobbit2.cache.entity.ParentSectionInfo;
import com.voole.hobbit2.cache.entity.ProductInfo;
import com.voole.hobbit2.cache.entity.ResourceInfo;
import com.voole.hobbit2.cache.entity.SpInfo;
import com.voole.hobbit2.cache.entity.VlsServerInfo;
import com.voole.hobbit2.cache.entity.VlsServerInfo.VlsServerType;
import com.voole.hobbit2.cache.entity.live.LiveChannelConfig;
import com.voole.hobbit2.cache.entity.live.LiveProgramInfo;
import com.voole.hobbit2.cache.entity.live.LiveTerminalConfig;
import com.voole.hobbit2.common.Tuple;

/**
 * @author XuehuiHe
 * @date 2013年10月30日
 */
public class CacheDao implements OemInfoFetch, AreaInfosFetch,
		ResourceInfoFetch, MovieInfoFetch, ParentAreaInfoFetch,
		ParentSectionInfoFetch, ProductInfoFetch, SpInfosFetch {

	private JdbcTemplate realtimeJt;

	public RangeMap<Long, AreaInfo> getVooleIpRanges() {
		String sql = "SELECT si.dim_area_id, si.dim_nettype_id AS nettype, si.`minip`, si.`maxip` FROM dim_ipzone si WHERE si.`maxip`>si.`minip` ";
		final RangeMap<Long, AreaInfo> result = TreeRangeMap.create();
		realtimeJt.query(sql, new RowMapper<Void>() {

			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				result.put(
						Range.closed(rs.getLong("minip"), rs.getLong("maxip"))
								.canonical(DiscreteDomain.longs()),
						new AreaInfo(rs.getInt("dim_area_id"), rs
								.getInt("nettype")));

				return null;
			}
		});
		return result;
	}

	public List<BoxStoreAreaInfo> getLiveBoxStoreAreaInfos() {
		String sql = "SELECT b.`areaid`, s.`dim_nettype_id`, b.`oemid`, b.`mac` FROM dim_store b JOIN dim_isp s  ON (s.`id` = b.`spid`)";
		return realtimeJt.query(sql, new RowMapper<BoxStoreAreaInfo>() {

			@Override
			public BoxStoreAreaInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				BoxStoreAreaInfo areaInfo = new BoxStoreAreaInfo();
				areaInfo.setOemid(rs.getString("oemid"));
				areaInfo.setMac(rs.getString("mac"));
				areaInfo.setAreaid(rs.getInt("areaid"));
				areaInfo.setNettype(rs.getInt("dim_nettype_id"));
				return areaInfo;
			}
		});
	}

	public Map<String, RangeMap<Long, AreaInfo>> getSpIpRanges() {
		final Map<String, RangeMap<Long, AreaInfo>> map = new HashMap<String, RangeMap<Long, AreaInfo>>();
		String sql = "SELECT  si.dim_area_id, si.dim_nettype_id AS nettype, si.dim_isp_id, si.`minip`, si.`maxip` FROM dim_sp_ipzone si WHERE si.`maxip`>si.`minip` ";
		realtimeJt.query(sql, new RowMapper<Void>() {

			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {

				String spid = rs.getString("dim_isp_id");
				if (spid != null && spid.length() > 0) {
					RangeMap<Long, AreaInfo> rangeMap = null;
					if (!map.containsKey(spid)) {
						rangeMap = TreeRangeMap.create();
						map.put(spid, rangeMap);
					} else {
						rangeMap = map.get(spid);
					}
					rangeMap.put(
							Range.closed(rs.getLong("minip"),
									rs.getLong("maxip")).canonical(
									DiscreteDomain.longs()),
							new AreaInfo(rs.getInt("dim_area_id"), rs
									.getInt("nettype")));
				}
				return null;
			}
		});

		return map;
	}

	public Map<Integer, ParentAreaInfo> getParentAreaMap() {
		final Map<Integer, ParentAreaInfo> map = new HashMap<Integer, ParentAreaInfo>();
		String sql = "SELECT id,parentid FROM dim_area where parentid <>'' ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				ParentAreaInfo info = new ParentAreaInfo();
				info.setParentid(rs.getInt("parentid"));
				map.put(id, info);
				return null;
			}
		});
		return map;
	}

	/**
	 * @return
	 */
	public List<LiveTerminalConfig> getTerminalConfigs() {
		String sql = "SELECT l.`channelcode`,l.`tid`,l.`ctype`,l.`localcode` FROM live_terminal_config l";
		return realtimeJt.query(sql, new RowMapper<LiveTerminalConfig>() {

			@Override
			public LiveTerminalConfig mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				LiveTerminalConfig config = new LiveTerminalConfig();
				config.setChannelcode(rs.getString("channelcode"));
				config.setCtype(rs.getInt("ctype"));
				config.setLocalcode(rs.getString("localcode"));
				config.setTid(rs.getString("tid"));
				return config;
			}
		});
	}

	/**
	 * @return
	 */
	public List<OemInfo> getOemInfos() {
		String sql = "SELECT o.`oemid`,o.name,o.`repeat_portalid`,o.`live_portalid`,o.`dim_isp_id`,o.`tid`,o.`policyid`,o.`name` FROM dim_oem o  ";
		return realtimeJt.query(sql, new RowMapper<OemInfo>() {

			@Override
			public OemInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				OemInfo info = new OemInfo();
				info.setOemid(rs.getLong("oemid"));
				info.setRepeatPortalid(rs.getString("repeat_portalid"));
				info.setLivePortalid(rs.getString("live_portalid"));
				info.setSpid(rs.getString("dim_isp_id"));
				info.setTid(rs.getLong("tid"));
				info.setPolicyid(rs.getLong("policyid"));
				info.setShortname(rs.getString("name"));
				return info;
			}
		});
	}

	/**
	 * @return
	 */
	public List<LiveChannelConfig> getLiveChannelConfigs() {
		String sql = "SELECT l.`channelcode`, l.`ctype`, l.`starttime`, l.`programname` FROM live_channel_config l WHERE l.`starttime` >= DATE_SUB(NOW(), INTERVAL 17 HOUR) AND l.`starttime` <= DATE_ADD(NOW(), INTERVAL 25 HOUR)";
		return realtimeJt.query(sql, new RowMapper<LiveChannelConfig>() {

			@Override
			public LiveChannelConfig mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				LiveChannelConfig config = new LiveChannelConfig();
				config.setChannelcode(rs.getString("channelcode"));
				config.setCtype(rs.getInt("ctype"));
				config.setStarttime(rs.getTimestamp("starttime"));
				config.setProgramname(rs.getString("programname"));
				return config;
			}
		});
	}

	/**
	 * @return
	 */
	public List<DeviceInfo> getDeviceInfos() {
		String sql = "SELECT i.idcid, i.areaid, i.idc_nettype AS nettype, d.`d_ip_dx`, d.`d_ip_lt` FROM idc i, tab_device d WHERE i.idcid = d.d_idc_id ";
		return realtimeJt.query(sql, new RowMapper<DeviceInfo>() {

			@Override
			public DeviceInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				final DeviceInfo info = new DeviceInfo();
				info.setAreaid(rs.getInt("areaid"));
				info.setIdcid(rs.getString("idcid"));
				info.setNettype(rs.getInt("nettype"));

				info.setDxIp(rs.getString("d_ip_dx"));
				info.setLtIp(rs.getString("d_ip_lt"));
				return info;
			}
		});
	}

	/**
	 * @return
	 */
	public Map<String, String> getSpidToMovieSpidMap() {
		String sql = "SELECT spid, movieshare_sp FROM sp ";
		final Map<String, String> map = new HashMap<String, String>();
		realtimeJt.query(sql, new RowMapper<Void>() {

			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				map.put(rs.getString("spid"), rs.getString("movieshare_sp"));
				return null;
			}
		});
		return map;
	}

	/**
	 * @return
	 */
	public Map<String, String> getSpidToTerminalSpidMap() {
		String sql = "SELECT spid, tidshare_sp FROM sp ";
		final Map<String, String> map = new HashMap<String, String>();
		realtimeJt.query(sql, new RowMapper<Void>() {

			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				map.put(rs.getString("spid"), rs.getString("tidshare_sp"));
				return null;
			}
		});
		return map;
	}

	/**
	 * @return
	 * @deprecated since 2013-12-04
	 */
	public Map<Tuple<String, String>, Integer> getResourceToBitrateMap() {
		final Map<Tuple<String, String>, Integer> map = new HashMap<Tuple<String, String>, Integer>();
		String sql = "SELECT IFNULL(rs.`bitrate`, 0) bitrate, rs.`fid`, rs.`spid` FROM resource_src rs ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				String fid = rs.getString("fid");
				if (fid != null) {
					fid = fid.toLowerCase();
				}
				map.put(new Tuple<String, String>(rs.getString("spid"), fid),
						rs.getInt("bitrate"));

				return null;
			}
		});
		return map;
	}

	public Map<String, ResourceInfo> getResourceMap() {
		final Map<String, ResourceInfo> map = new HashMap<String, ResourceInfo>();
		String sql = "SELECT IFNULL(rs.`bitrate`, 0) bitrate, rs.`fid`, rs.`mid`, rs.`duration`,rs.series,rs.mimeid FROM dim_media rs ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				String fid = rs.getString("fid");
				if (fid != null) {
					fid = fid.toUpperCase();
				}
				ResourceInfo info = new ResourceInfo();
				info.setBitrate(rs.getInt("bitrate"));
				info.setDuration(rs.getInt("duration"));
				info.setMid(rs.getLong("mid"));
				info.setSeries(rs.getInt("series"));
				info.setMimeid(rs.getInt("mimeid"));
				map.put(fid, info);

				return null;
			}
		});
		return map;
	}

	public Map<Long, MovieInfo> getMovieMap() {
		final Map<Long, MovieInfo> map = new HashMap<Long, MovieInfo>();
		String sql = "SELECT rs.`mid`, rs.`dim_cp_id`, rs.`category` FROM dim_movie rs ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				Long mid = rs.getLong("mid");
				MovieInfo info = new MovieInfo();
				info.setCategory(rs.getString("category"));
				info.setDim_cp_id(rs.getInt("dim_cp_id"));
				map.put(mid, info);
				return null;
			}
		});
		return map;
	}

	public Map<Tuple<String, String>, ProductInfo> getProductInfos_old() {
		final Map<Tuple<String, String>, ProductInfo> map = new HashMap<Tuple<String, String>, ProductInfo>();
		String sql = "SELECT spid,product_id,ifnull(ptype,0) ptype,ifnull(fee,0) fee FROM isp_product ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductInfo info = new ProductInfo();
				info.setPtype(rs.getInt("ptype"));
				info.setFee(rs.getInt("fee"));
				info._process();
				map.put(new Tuple<String, String>(rs.getString("spid"), rs
						.getString("product_id")), info);

				return null;
			}
		});
		return map;
	}

	public Map<Tuple<String, String>, ProductInfo> getProductInfos() {
		final Map<Tuple<String, String>, ProductInfo> map = new HashMap<Tuple<String, String>, ProductInfo>();
		String sql = "select t.id,t.pid,ifnull(p.ptype,0) ptype,ifnull(t.fee,0) fee from  dim_po_product t  inner join dim_product p on( t.pid = p.pid) ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductInfo info = new ProductInfo();
				info.setPtype(rs.getInt("ptype"));
				info.setFee(rs.getInt("fee"));
				info._process();
				map.put(new Tuple<String, String>(rs.getString("id"), rs
						.getString("pid")), info);

				return null;
			}
		});
		return map;
	}

	public Map<String, ParentSectionInfo> getParentSectionMap() {
		final Map<String, ParentSectionInfo> map = new HashMap<String, ParentSectionInfo>();
		String sql = "SELECT t.code,(select code from dim_section ms where ms.id=t.parentid limit 0,1) parentcode FROM dim_section t where parentid>0 ";
		realtimeJt.query(sql, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				ParentSectionInfo info = new ParentSectionInfo();
				info.setCode(rs.getString("parentcode"));
				map.put(rs.getString("code"), info);
				return null;
			}
		});
		return map;
	}

	public List<SpInfo> getSpInfos() {
		String sql = "SELECT d.`id`,d.`name`,d.`dim_nettype_id` FROM dim_isp d";
		List<SpInfo> spInfos = new ArrayList<SpInfo>();
		spInfos = realtimeJt.query(sql, new RowMapper<SpInfo>() {

			@Override
			public SpInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				SpInfo info = new SpInfo();
				info.setSpid(rs.getString("id"));
				info.setShortname(rs.getString("name"));
				info.setNettype(rs.getInt("dim_nettype_id"));
				return info;
			}
		});
		return spInfos;
	}

	public Map<String, String> getIdcToSp() {
		String sql = "SELECT s.`idcid`,s.`spid` FROM idc_sp s";
		final Map<String, String> map = new HashMap<String, String>();
		realtimeJt.query(sql, new RowMapper<Void>() {

			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
				map.put(rs.getString("idcid"), rs.getString("spid"));
				return null;
			}
		});
		return map;
	}

	public List<VlsServerInfo> getVlsSeverInfo() {
		String sql = "SELECT n.`id`,n.`name`,n.`ip`,n.`type` FROM vls_server_name n";
		return realtimeJt.query(sql, new RowMapper<VlsServerInfo>() {
			@Override
			public VlsServerInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				VlsServerInfo info = new VlsServerInfo();
				info.setId(rs.getInt("id"));
				info.setIp(rs.getString("ip"));
				info.setName(rs.getString("name"));
				int type = rs.getInt("type");
				if (!rs.wasNull()) {
					info.setType(VlsServerType.getType(type));

				}
				return info;
			}
		});
	}

	public void updateVlsSeverInfo(VlsServerInfo info) {
		String sql = "REPLACE INTO `vls_server_name` (`id`, `name`,`ip`,`type`) VALUES (?, ?, ?,?)";
		realtimeJt.update(sql, new Object[] { info.getId(), info.getName(),
				info.getIp(), info.getType().getType() });
	}

	public List<EpgInfo> getEpgInfos() {
		String sql = "SELECT t.`tid`,t.`ispid`,t.`pname` FROM terminal t WHERE t.`status` = 1";
		return realtimeJt.query(sql, new RowMapper<EpgInfo>() {

			@Override
			public EpgInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				EpgInfo epgInfo = new EpgInfo();
				epgInfo.setTid(rs.getLong("tid"));
				epgInfo.setIspid(rs.getString("ispid"));
				epgInfo.setPname(rs.getString("pname"));
				return epgInfo;
			}
		});
	}

	public Integer getProgramId(String channelid, Integer ctype,
			Date starttime, Date endtime) {
		String sql = "";
		sql += "SELECT ";
		sql += "  lc.`seqno`, lc.`starttime`, lc.`endtime` ";
		sql += "FROM";
		sql += "  live_channel_config lc ";
		sql += "WHERE lc.`channelcode` = :channelid ";
		sql += "  AND lc.`ctype` = :ctype ";
		sql += "  AND lc.`endtime` <> 0  ";
		sql += "  AND (";
		sql += "    (";
		sql += "      lc.`starttime` >= :starttime";
		sql += "      AND lc.`endtime` <= :endtime";
		sql += "    ) ";
		sql += "    OR (";
		sql += "      lc.`starttime` <= :endtime";
		sql += "      AND lc.`endtime` >= :endtime";
		sql += "    ) ";
		sql += "    OR (";
		sql += "      lc.`starttime` <= :starttime";
		sql += "      AND lc.`endtime` >= :starttime";
		sql += "    )";
		sql += "  )";

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				realtimeJt);
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("channelid", channelid);
		paramMap.addValue("ctype", ctype);
		paramMap.addValue("starttime", starttime);
		paramMap.addValue("endtime", endtime);
		List<LiveProgramInfo> list = namedParameterJdbcTemplate.query(sql,
				paramMap, new RowMapper<LiveProgramInfo>() {
					@Override
					public LiveProgramInfo mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						LiveProgramInfo info = new LiveProgramInfo();
						info.setSeqno(rs.getInt("seqno"));
						info.setStarttime(rs.getTimestamp("starttime"));
						info.setEndtime(rs.getTimestamp("endtime"));
						return info;
					}
				});
		if (list.size() == 0) {
			return 0;
		} else if (list.size() == 1) {
			return list.get(0).getSeqno();
		}
		long diff = Long.MAX_VALUE;
		Integer pid = 0;
		long middle = (starttime.getTime() + endtime.getTime()) / 2;
		for (LiveProgramInfo item : list) {
			long itemDiff = Math.abs(middle
					- (item.getStarttime().getTime() + item.getEndtime()
							.getTime()) / 2);
			if (itemDiff < diff) {
				pid = item.getSeqno();
				diff = itemDiff;
			}
		}
		return pid;
	}

	public JdbcTemplate getRealtimeJt() {
		return realtimeJt;
	}

	public void setRealtimeJt(JdbcTemplate realtimeJt) {
		this.realtimeJt = realtimeJt;
	}

}
