/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalavit.javulna.services;

import com.kalavit.javulna.dto.MovieDto;
import com.kalavit.javulna.model.Movie;
import com.kalavit.javulna.services.autodao.MovieAutoDao;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;


@RequestMapping("/MovieService")
public class Cls extends HttpServlet
{
    private static org.apache.log4j.Logger log = Logger.getLogger(Register.class);

    // ruleid:find-sql-string-concatenation
    @PostMapping("/findMovie")
    protected void danger(String ean) {
        Session session = this.sessionFactory.openSession();

        String query = "select foo from bar where" + ean + " limit 1";
        try {
            PreparedStatement ps = session.connection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer item = rs.getInt("foo");
            }
        } catch (SQLException e) {
            logger.error("Error!", e);
        } finally {
            session.close();
        }
    }
    // ruleid:find-sql-string-concatenation
    protected void danger2(String biz) {
        String query = "select foo from bar where" + biz + " limit 1";
        Session session = this.sessionFactory.openSession();
        try {
            PreparedStatement ps = session.connection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer item = rs.getInt("foo");
            }
        } catch (SQLException e) {
            logger.error("Error!", e);
        } finally {
            session.close();
        }
    }

    // ok:find-sql-string-concatenation
    protected void ok(String foo) throws ServletException, IOException {
        String query = "select foo from bar where ? limit 1";
        Session session = this.sessionFactory.openSession();
        try {
            PreparedStatement ps = session.connection().prepareStatement(query);
            ps.setString(1,foo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("foo");
            }
        } catch (SQLException e) {
            logger.error("Error!", e);
        } finally {
            session.close();
        }
    }
}
