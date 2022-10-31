package com.example.lse_bot.repo;


import com.example.lse_bot.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LseRepo {
    @Autowired
    public LseRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final JdbcTemplate jdbcTemplate;
    RowMapper<NewsModel> newsRowMapper = new RowMapper<NewsModel>() {
        @Override
        public NewsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            NewsModel news = new NewsModel();
            news.setCompanyName(rs.getString("companyname"));
            news.setIssuerName(rs.getString("issuername"));
            news.setIssuerName(rs.getString("datetime"));
            return news;
        }
    };
    public List getNews()
    {
        String query="Select * from news";
      return   jdbcTemplate.query(query,newsRowMapper);
    }
}